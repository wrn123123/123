package com.netty.demo;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Main {
    static class MyTimerTask implements TimerTask {

        boolean flag;
        public MyTimerTask(boolean flag){
            this.flag = flag;
        }
        public void run(Timeout timeout) throws Exception {
            // TODO Auto-generated method stub
            System.out.println("要去数据库删除订单了。。。。");
            this.flag =false;
        }
    }
    public static void main(String[] argv) {
        MyTimerTask timerTask = new MyTimerTask(true);
        HashedWheelTimer timer = new HashedWheelTimer();
        timer.newTimeout(timerTask, 5, TimeUnit.SECONDS);
        int i = 1;
        while(timerTask.flag){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(i+"秒过去了");
            i++;
        }
    }
}
