package com.yyp.luogu;

import java.io.*;
import java.util.*;

/**
 * 不知道什么原因超内存，后期题目将采用c++写了
 */
public class P1271 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        int nums[] = new int[m];
        for(int i = 0; i < m; i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        for(int i = 0; i < m - 1; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.print(nums[m - 1]);
    }
}

