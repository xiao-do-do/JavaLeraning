package com.xiaodo.learning.refleaction;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;


/**
 * class对象.getDeclaredFields(); 只获取自己类中声明的所有属性
 * class对象.getFieldsList() 包括父类的可访问的所有
 * 当然两者都可以获取指定名称了
 * class对象.getDeclaredFields(String name);
 * class对象.getFieldsList(String name) 包括父类的可访问的所有
 *
**/
class MySuperClass {
    public int super_id = -1;
    public String super_name = "Unknown";

}

class MyClass extends MySuperClass{
    public int id = -1;
    public String name = "Unknown";
}

public class FieldReflectTest {


    public static ArrayList<String> getFieldsList(Class c) {
        Field[] fields = c.getFields();
        ArrayList<String> fieldsList = getFieldsDesciption(fields);
        return fieldsList;
    }

    public static ArrayList<String> getDeclaredFieldsList(Class c) {
        Field[] fields = c.getDeclaredFields();
        ArrayList<String> fieldsList = getFieldsDesciption(fields);
        return fieldsList;
    }

    public static ArrayList<String> getFieldsDesciption(Field[] fields) {
        ArrayList<String> fieldList = new ArrayList<>();

        for (Field f : fields) {
            int mod = f.getModifiers() & Modifier.fieldModifiers();
            String modifiers = Modifier.toString(mod);

            Class<?> type = f.getType();
            String typeName = type.getSimpleName();

            String fieldName = f.getName();

            fieldList.add(modifiers + "  " + typeName + "  " + fieldName);
        }

        return fieldList;
    }

    public static void main(String[] args) {
        Class<MyClass> c = MyClass.class;

        // Print declared fields
        ArrayList<String> fieldsDesciption = getDeclaredFieldsList(c);

        System.out.println("Declared Fields for " + c.getName());
        for (String desc : fieldsDesciption) {
            System.out.println(desc);
        }
        fieldsDesciption = getFieldsList(c);

        System.out.println("\nAccessible Fields for " + c.getName());
        for (String desc : fieldsDesciption) {
            System.out.println(desc);
        }
    }
}

