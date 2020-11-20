package com.xiaodo.learning.proxy;


public class RealSubject implements Subject {
    public String SayHello(String name) {
        return "hello " + name;
    }

    public String SayGoodBye() {
        return " good bye ";
    }
}