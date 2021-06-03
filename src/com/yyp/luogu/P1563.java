package com.yyp.luogu;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 人方向朝内时，左数就是perPerson,右数就是nexPerson
 * 人方向朝外时，左数就是nextPerson,右数就是perPerson
 */

public class P1563 {
    //双向链表超时，需要采用数组形式
//    static class Person{
//        int direction;
//        String profession;
//        Person perPerson, nextPerson;
//    }
    //提高输入读取速度
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

//    static Person getPerson(Person start, int leftOrRight, int countNum){
//        int count = 0;
//        Person temp = start;
//        //向左数
//        if(leftOrRight == 0){
//            while(count < countNum){
//                //朝内
//                if(start.direction == 0){
//                    temp = temp.perPerson;
//                    count++;
//                }else {
//                    temp = temp.nextPerson;
//                    count++;
//                }
//            }
//            return temp;
//        }else{
//            while(count < countNum){
//                //朝内
//                if(start.direction == 0){
//                    temp = temp.nextPerson;
//                    count++;
//                }else {
//                    temp = temp.perPerson;
//                    count++;
//                }
//            }
//            return temp;
//        }
//    }

//    public static void main(String[] args) {
////        Scanner sc = new Scanner(new BufferedInputStream(System.in));
//        InputReader sc = new InputReader(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        Person head = new Person();
//        head.direction = sc.nextInt();
//        head.profession = sc.next();
//        Person temp = head;
//        //逆时针顺序存
//        for(int i = 1; i < n; i++){
//            Person mem = new Person();
//            mem.direction = sc.nextInt();
//            mem.profession = sc.next();
//            mem.perPerson = temp;
//            temp.nextPerson = mem;
//            //最后一个节点
//            if(i == n - 1){
//                head.perPerson = mem;
//                mem.nextPerson = head;
//            }
//            temp = mem;
//        }
//        Person ret = head;
//        for(int i = 0; i < m; i++){
//            //向左数还是向右数
//            int leftOrRight = sc.nextInt();
//            //数的个数
//            int countNum = sc.nextInt();
//            ret = getPerson(ret, leftOrRight, countNum);
//        }
//        System.out.println(ret.profession);
//    }

    // place是当前位置,n是人物个数,m是指令个数
    static int place = 0, n, m;
    // 存储人物朝向的数组
    static int[] N;
    // 存储人物名称的数组
    static String[] Name;

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        n = in.nextInt();
        m = in.nextInt();
        N = new int[n];
        Name = new String[n];
        // 读取所有的人物
        for (int i = 0; i < n; i++) {
            N[i] = in.nextInt();
            Name[i] = in.next();
        }
        // 读取所有操作同时计算
        for (int i = 0; i < m; i++) {
            opeart(in.nextInt(), in.nextInt());
        }
        System.out.println(Name[place]);
    }

    /**
     *
     * @param i 朝向
     * @param j 数数距离个数
     */
    static void opeart(int i, int j) {
        // 其实只有两种情况,
        // 1 如果朝向内侧又向左移动表示为 0 0,如果朝向外侧有向右移动表示为1 1,这种情况下应该用当前位置减去移动的距离
        // 2 朝向和移动方向不想同0 1或者1 0,则应该用当前位置加上移动的距离
        //朝向和移动方向属于第一种情况时
        if (N[place] == i) {
            //有负数情况需要加上n，所以当不为负数情况时加上n时，需要取余
            place = (place + n - j) % n;
        } else {
            place = (place + j) % n;
        }
    }
}

