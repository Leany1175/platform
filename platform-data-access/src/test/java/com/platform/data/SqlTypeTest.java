package com.platform.data;

import java.lang.reflect.Field;
import java.sql.Types;

public class SqlTypeTest {

    public static void main(String[] args) {
        Class<Types> clazz = Types.class;
        Field[] fields = clazz.getDeclaredFields();
        System.out.println(fields.length);
        for (Field field : fields) {
            System.out.println(field.getName());
        }

    }

}
