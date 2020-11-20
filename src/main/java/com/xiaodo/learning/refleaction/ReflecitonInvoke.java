package com.xiaodo.learning.refleaction;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射出来的对象中类属性可以直接修改，但是方法必须通过对象.getMethod(methodName, String.class方式获取)
 * 然后获取了Method对象.invoke(反射的对象,参数)来调用
 */
class MyClass4 {
    public String a ="a";
    public MyClass4() {
    }

    public void setName(String n) {
        System.out.println(n);
    }
}

public class ReflecitonInvoke {
    public static void main(String[] args) {
        Class<MyClass4> myClass = MyClass4.class;
        try {
            MyClass4 p = myClass.newInstance();

            Method setName = myClass.getMethod("setName", String.class);
            setName.invoke(p, "abc");
            System.out.println(p.a);
        } catch (InstantiationException | IllegalAccessException
                | NoSuchMethodException | SecurityException | IllegalArgumentException
                | InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
    }
}