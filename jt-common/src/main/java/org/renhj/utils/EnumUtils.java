package org.renhj.utils;

import org.renhj.base.BaseEnum;

public class EnumUtils {
    public static <T extends Enum<?> & BaseEnum> T codeOf(Class<T> enumClass, int code){
        T[] enumConstants = enumClass.getEnumConstants();
        for (T t: enumConstants){
            if (t.getCode() == code){
                return t;
            }
        }
        return null;
    }

    public static <T extends Enum<?> & BaseEnum> String valueOf(Class<T> enumClass, int code){
        T[] enumConstants = enumClass.getEnumConstants();
        for (T t: enumConstants){
            if (t.getCode() == code){
                return t.getDesc();
            }
        }
        return null;
    }

 }
