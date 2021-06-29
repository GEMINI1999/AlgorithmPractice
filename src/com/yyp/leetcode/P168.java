package com.yyp.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Excel表列名称
 * 26进制
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * num/26 = num1
 * num%26 = 余数 ->>存入数组，最后倒序输出
 * ...
 * 直到
 * num/26 = 0
 *
 * 1 2 3 4 5 6 7 8 9 10 ... 26  27 28 29
 * A B C D E F G H I J  ... Z   AA AB AC
 * 0 1 2 3 4 5 6 7 8 9  ... 25  10 11 12
 */
public class P168 {
    public static String convertToTitle(int columnNumber) {
        if(columnNumber <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0){
            /**
             * 每次减1变成正常的26进制
             * 例如27（从1开始）实际上应该是 26（从0开始）
             * 26转化为26进制为 10，而我们用0表示A所以要减一
             */
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber = columnNumber / 26;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String ret = convertToTitle(num);
        System.out.println(ret);
    }
}

