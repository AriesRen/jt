package org.renhj.utils;

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import org.renhj.common.BaseEnum;

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
}
