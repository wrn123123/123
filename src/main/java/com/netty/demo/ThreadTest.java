package com.netty.demo;

public class ThreadTest {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                System.out.println(getName()+getState());
            }
        };
        System.out.println(t1.getState());
        t1.start();
        
    }

}
