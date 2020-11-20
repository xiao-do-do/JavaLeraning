package com.xiaodo.learning.refleaction;

/**
 * class.newInstance()使用空的构造函数生成反射的实例。
 */
class MyClass2 {
  public String a = "1";
  public MyClass2() {
     System.out.println("构造方法");
  }
}
public class ReflectionObject {
  public static void main(String[] args)  {
    Class<MyClass2> personClass = MyClass2.class;
    try {
      MyClass2 p = personClass.newInstance();
      System.out.println(p.a);
    } catch (InstantiationException | IllegalAccessException e) {
      System.out.println(e.getMessage());
    }
  }
}