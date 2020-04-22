package com.zcw.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @author : ville
 * @version : 1.0.0
 * @description : map转bean
 * @createTime : 2020/4/22-7:11 下午
 * @copyright : ville
 * @modify : ville
 **/
@Slf4j
public class MapToBeanUtil {
    public static Object entity(Object object, LinkedHashMap linkedHashMap) {

        Set keySet = linkedHashMap.keySet();
        Field[] fields = object.getClass().getDeclaredFields();

        String[] fieldNames = new String[fields.length];
        String[] fieldTypes = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fieldNames[i] = fields[i].getName();
            fieldTypes[i] = fields[i].getGenericType().toString();
            fields[i].setAccessible(true);
            for (Object key : keySet) {
                if (fieldNames[i].equalsIgnoreCase(key.toString())) {
                    try {
                        fields[i].set(object, linkedHashMap.get(key));
                    } catch (IllegalAccessException e) {
                     log.error("error:"+e.getMessage());
                    }
                }
            }
        }
        return object;
    }
}
