package com.xiaodo.learning.refleaction;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 获取对象的构造对象class.getConstructor(参数1类型.class,  参数2类型.class)
 * cons.newInstance(1,"abc")
 * 这样类生成实例

 */
class MyClass3 {
  public MyClass3(int i, String s) {
    System.out.println("构造方法");
    System.out.println(i);
    System.out.println(s);
  }
}
public class ReflectionConstruct {
  public static void main(String[] args) {
    Class<MyClass3> myClass = MyClass3.class;
    try {
      Constructor<MyClass3> cons = myClass.getConstructor(int.class,
          String.class);
      MyClass3 chris = cons.newInstance(1, "abc");
      System.out.println(chris);
    } catch (NoSuchMethodException | SecurityException | InstantiationException
        | IllegalAccessException | IllegalArgumentException
        | InvocationTargetException e) {
      System.out.println(e.getMessage());
    }
  }
}