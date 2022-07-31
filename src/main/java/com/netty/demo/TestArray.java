package com.netty.demo;

import java.util.*;

public class TestArray {
    protected transient int i = 0;

    public static void main(String[] args) {
        List list = new ArrayList<>();

        list.add("123");
        list.add("144");
        list.add("123");
        list.add(null);
        list.add(null);
        list.toArray();
        System.out.println(list);
        Set set = new HashSet();
        set.add("123");
        list.add("333");
        list.add("3213");


        long l = System.currentTimeMillis();
        for (int i = 0; i <1000000 ; i++) {
            list.add(i + "");
        }
        long l1 = System.currentTimeMillis();
        System.out.println("添加时间"+(l1-l));

        TestArray testArray = new TestArray();
        testArray.aa();
        testArray.cc();


    }
    void aa(){
        System.out.println(++i);
    }
    void cc(){
        System.out.println(++i);
    }
}
class Aa extends TestArray{
    public void add(){
        ++i;
        System.out.println(i);
    }
    public void cc(){
        ++i;
        System.out.println(i);
    }


    public static void main(String[] args) {
        Aa aa = new Aa();
        aa.add();
        aa.cc();
    }
}
