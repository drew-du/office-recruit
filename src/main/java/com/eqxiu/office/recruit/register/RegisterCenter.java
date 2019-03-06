package com.eqxiu.office.recruit.register;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RegisterCenter {
    private static Map<String, Function> registry = new HashMap<>();
    private static Map<String, Object> objectMap = new HashMap<>();

    private RegisterCenter() {}

    @SuppressWarnings("unchecked")
    public static <T> T getValue(String key, Object... args){
        if (!registry.containsKey(key) || registry.get(key) == null) {
            registry.remove(key);
            return null;
        }
        return (T)registry.get(key).execute(args);
    }

    public static <T> T getValue(String key, Map<String, Object> params){
        Function function = registry.get(key);
        if (function != null){
            Object[] args = new Object[function.args().length];
            for (int i = 0; i < function.args().length; i++){
                args[i] = params.get(function.args()[i]);
            }
            return getValue(key, args);
        }
        return null;
    }

    public static <T> void register(Class<T> classType) {
        if (classType == null)
            return;
        try{
            Method[] methods = classType.getMethods();
            for(Method method: methods){
                if (method.isAnnotationPresent(Register.class)){
                    Register function = method.getAnnotation(Register.class);
                    String key = function.key();
                    if (registry.containsKey(key)){
                        System.out.println(key + " is exist");
                    } else {
                        registry.put(key, new Function(method, function.args(), classType.newInstance()));
                    }
                }
            }
        } catch (InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }

    public static void clear() {
        registry.clear();
    }

    public static void unregister(String key) {
        registry.remove(key);
    }

    public static boolean containsKey(String key) {
        return registry.containsKey(key);
    }

    public static boolean containsObject(String key) {
        return objectMap.containsKey(key);
    }

    static Object getObject(String key){
        return objectMap.get(key);
    }

    static void putObject(String key, Object object) {
        objectMap.put(key, object);
    }
}
