package com.mall.huitop.service;

public class Test{
    public static void main(String[] args) {
        Integer a = 600;
        System.out.println(a);
        Integer b = 200;

        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
        System.out.println(a == b);
    }
}
