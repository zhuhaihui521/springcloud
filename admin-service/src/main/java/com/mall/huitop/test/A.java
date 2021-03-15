package com.mall.huitop.test;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-21 20:40
 */
public class A {
     Object o=new Object();
     int num=888888888;
     String c="888888888";
     Long d=58l;
     boolean re=false;
     public int a1(){
        synchronized (o){
            if (re){
               return num+num;
            }else {
                return num;
            }
        }
    }

    public void a2(){
        synchronized (o){
            num=2;
            re=true;
        }
    }
}
