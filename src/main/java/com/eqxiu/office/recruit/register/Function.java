package com.eqxiu.office.recruit.register;

import com.eqxiu.office.recruit.util.Util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Function{
    private Object obj;
    private Method method;
    private String[] args;

    private Function() {}
    Function(Method method, String[] args, Object obj){
        this.method = method;
        this.args = args;
        this.obj = obj;
    }

    static Function parseFunction(String s) {
        try {
            char[] value = s.toCharArray();
            int index1 = -1, index2 = -1;
            for(int i = 0; i < value.length; i++) {
                if(value[i] == '.') {
                    index1 = i;
                } else if(value[i] == '(') {
                    index2 = i;
                    break;
                }
            }
            String className = new String(value, 0, index1);
            String methodName = new String(value, index1 + 1, index2-index1-1);
            String[] parameters = Util.split(new String(value, index2+1, value.length-index2-2).trim(), ',').toArray(new String[0]);
            String[] parameterTypeNames = new String[parameters.length];
            String[] args = new String[parameters.length];
            for(int i = 0; i < parameters.length; i++) {
                String[] temp = Util.split(parameters[i], ' ', '+').toArray(new String[0]);
                parameterTypeNames[i] = temp[0];
                args[i] = temp[1];
            }

            Class<?>[] parameterTypes = new Class<?>[parameterTypeNames.length];
            for(int i = 0; i < parameterTypeNames.length; i++) {
                parameterTypes[i] = Class.forName(parameterTypeNames[i]);
            }
            if (!RegisterCenter.containsObject(className) || RegisterCenter.getObject(className) == null) {
                Class<?> clazz = Class.forName(className);
                RegisterCenter.putObject(className, clazz.newInstance());
            }
            Function function = new Function();
            function.obj = RegisterCenter.getObject(className);
            function.method = function.obj.getClass().getMethod(methodName, parameterTypes);
            function.args = args;
            return function;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    Object execute(Object... args) {
        Object result = null;
        try {
            result = method.invoke(obj, args);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    String[] args(){
        return args;
    }
}
