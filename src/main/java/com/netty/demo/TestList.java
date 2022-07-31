package com.netty.demo;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestList {

    static class WaitingTime implements Runnable{

        @Override
        public void run() {
            while (true){
                waitSecord(200);
            }
        }
        public final void waitSecord(long second){
            try{
                TimeUnit.SECONDS.sleep(second);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class WaitingState implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (TestList.class) {
                    try {
                        TestList.class.wait(5);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    static class BlockedThread implements Runnable{

        @Override
        public void run() {
            while (true) {
                synchronized (BlockedThread.class) {
                    try {
                        WaitingTime waitingTime = new WaitingTime();
                        waitingTime.waitSecord(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
//        new Thread(new WaitingTime(), "waitetimeThread").start();
//        new Thread(new WaitingState(), "waitestateThread").start();
//
//        new Thread(new BlockedThread(), "blockenThread-01").start();
//        new Thread(new BlockedThread(), "blockenThread-02").start();
        Thread thread = new Thread(()->{
            System.out.println("111");
        });
        Thread thread1 = new Thread(()->{
            System.out.println("222");
        });
        Thread thread2 = new Thread(()->{
            System.out.println("333");
        });
        Thread thread3 = new Thread(()->{
            System.out.println("444");
        });
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
