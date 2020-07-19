package com.lqx.test;

/**
 * @author DUMBLEDOG
 * @date 2020/5/9 21:47
 */
public class HelllWorld {
    public static void main(String[] args) {
        System.out.println("测试中文乱码");
        String s = "小型货柜";
        String d = s.substring(0,2);
        System.out.println(d);
    }
}
