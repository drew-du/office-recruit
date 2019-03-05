package com.eqxiu.office.util;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class BeanMap {

    public static <T> Map<String, Object> bean2Map(T bean){
        if (bean == null){
            return Collections.emptyMap();
        }
        Map<String, Object> map = new HashMap<>();
        try{
            Class<?> beanClass = bean.getClass();
            Field[] beanFields = beanClass.getDeclaredFields();
            for(Field field: beanFields){
                field.setAccessible(true);
                FieldName fieldName = field.getAnnotation(FieldName.class);
                if (fieldName == null){
                    map.put(field.getName(), field.get(bean));
                } else {
                    if (fieldName.Ignore())
                        continue;
                    map.put(fieldName.value(), field.get(bean));
                }
            }
        }catch (IllegalAccessException | NullPointerException e){
            e.printStackTrace();
        }
        return map;
    }

    public static <T> T map2Bean(Map<String, Object> map, Class<T> beanClass){
        try {
            T bean = beanClass.newInstance();
            Field[] beanFields = beanClass.getDeclaredFields();
            for (Field field: beanFields){
                field.setAccessible(true);
                FieldName fieldName = field.getAnnotation(FieldName.class);
                if (Modifier.isFinal(field.getModifiers()) || Modifier.isStatic(field.getModifiers())){
                    continue;
                }
                if (fieldName != null && !fieldName.Ignore()){
                    field.set(bean, map.get(fieldName.value()));
                } else {
                    field.set(bean, map.get(field.getName()));
                }
            }
            return bean;
        } catch (InstantiationException | IllegalAccessException | NullPointerException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * use annotations to customize fields
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
    static public @interface FieldName{
        String value() default "";
        boolean Ignore() default false;
    }

}
