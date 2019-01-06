package org.renhj.common.utils.convert;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class MapObjectConvert {
    public static Object map2Object(Map<String, Object> map, Class<?> clz) throws IllegalAccessException, InstantiationException {
        if (map == null) return null;
        Object obj = clz.newInstance();

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field: fields) {
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                continue;
            }
            field.setAccessible(true);
            field.set(obj, map.get(field.getName()));
        }
        return obj;
    }

    public static Map<String, Object> object2Map(Object obj) throws IllegalAccessException {
        if (obj == null) return null;
        Map<String,Object> map = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field: fields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }
        return map;
    }
}
