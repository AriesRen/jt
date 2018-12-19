package org.renhj.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class JsonUtils {
    // 对象转json字符串
    public static String obj2json(Object obj) {
       return JSON.toJSONString(obj);
    }

    // json对象转java对象
    public static <T> T json2Obj(String json, Class<T> clazz){
        return JSON.parseObject(json, clazz);
    }

    public static <T> T map2Obj(Map<?,?> map, Class<T> clazz){
        return JSON.parseObject(JSON.toJSONString(map), clazz);
    }

    public static <T> Map json2Map(String json){
        return JSON.parseObject(json, Map.class);
    }

    public static Map<String, Object> obj2Map(Object obj) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        if (obj == null) return null;
        Map<String, Object> map = new HashMap<String, Object>();
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property: propertyDescriptors){
            String key = property.getName();
            if (key.compareToIgnoreCase("class") == 0){
                continue;
            }
            Method getter = property.getReadMethod();
            Object value = getter!=null? getter.invoke(obj): null;
            map.put(key, value);
        }
        return map;
    }
}
