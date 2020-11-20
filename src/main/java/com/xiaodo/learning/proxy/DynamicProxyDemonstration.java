package com.xiaodo.learning.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyDemonstration {
    /**
     *  被代理的真实对象为何一定要继承一个接口？
     *  创建的代理类是继承自Proxy类的，然后转换为一个类似与真实对象的一个代理类，他们不实现统一个接口，那么如何转换呢？？？
     *  SO，JDK动态代理拿到真实对象的接口，必然也会实现这个接口。
     */
    public static void main(String[] args) {
        //代理的真实对象
        Subject realSubject = new RealSubject();

        InvocationHandler handler = new InvocationHandlerImpl(realSubject);

        ClassLoader loader = realSubject.getClass().getClassLoader();
        Class[] interfaces = realSubject.getClass().getInterfaces();


        Subject subject = (Subject) Proxy.newProxyInstance(loader, interfaces, handler);
        /**
         * 实现了InvocationHandler他们就都具有了共同的方法，Invoke,
         * Proxy.newProxyInstance创建代理对象
         * 当代理对象调用对应方法时候，会调用InvocationHandle中的invoke方法，Invoke在调用真实对象的方法。
         */

        System.out.println("动态代理对象的类型：" + subject.getClass().getName());

        String hello = subject.SayHello("hello");
        System.out.println(hello);

    }

}