package org.mc.study.server.message;

import java.util.Scanner;

/**
 * @author machao
 * @date 2021/4/5
 */
public class Test {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // next方式接收字符串
        System.out.println("next方式接收：");
        // 判断是否还有输入
        if (scan.hasNext()) {
            String str1 = scan.next();
            String str2 = scan.next();
            System.out.println("输入的数据为：" + str1+","+str2);
        }
        scan.close();
    }

}
