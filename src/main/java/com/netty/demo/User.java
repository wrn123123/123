package com.netty.demo;

import lombok.Data;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Data
public class User {
    private  String name;
    private String age;
    private Cc cc;
    volatile static int i = 1;
    public class Cc{
        public String getClassname() {
            return classname;
        }

        public void setClassname(String classname) {
            this.classname = classname;
        }

        private String classname = "张三";
    }
    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override

            public void run() {
                int i = 0;
                i = 10;
                System.out.println(i);
            }
        };
        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                int j = i;
                System.out.println(j);
            }
        };
        t1.start();
        t2.start();

    }


    public void bb() {
        System.out.println("bbbbbb");
    }

    private static class Node<String> {
        String item;
        Node<String> next;
        Node<String> prev;

        Node(Node<String> prev, String item, Node<String> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
