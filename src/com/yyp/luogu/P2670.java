package com.yyp.luogu;

import java.util.Scanner;

public class P2670 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //行
        int n = sc.nextInt();
        //列
        int m = sc.nextInt();
        //吃回车
        sc.nextLine();
        //可以开一个多一圈的数组，可以省去判断下标越界的情况
        char [][] data = new char[n][m];
        for(int i = 0; i < n; i++){
            String line = sc.nextLine();
            for(int j = 0; j < m; j++){
                data[i][j] = line.charAt(j);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(data[i][j] != '*'){
                    int count = 0;
                    //上
                    if(i - 1 >= 0 && data[i - 1][j] == '*'){
                        count++;
                    }
                    //下
                    if(i + 1 < n && data[i + 1][j] == '*'){
                        count++;
                    }
                    //左
                    if(j - 1 >= 0 && data[i][j - 1] == '*'){
                        count++;
                    }
                    //右
                    if(j + 1 < m && data[i][j + 1] == '*'){
                        count++;
                    }
                    //左上
                    if(j - 1 >= 0 && i - 1 >= 0 && data[i - 1][j - 1] == '*'){
                        count++;
                    }
                    //右上
                    if(j + 1 < m && i - 1 >= 0 && data[i - 1][j + 1] == '*'){
                        count++;
                    }
                    //左下
                    if(j - 1 >= 0 && i + 1 < n && data[i + 1][j - 1] == '*'){
                        count++;
                    }
                    //右下
                    if(j + 1 < m && i + 1 < n && data[i + 1][j + 1] == '*'){
                        count++;
                    }
                    System.out.print(count);
                }else {
                    System.out.print('*');
                }
            }
            if(i != n - 1) {
                System.out.print('\n');
            }
        }

    }
}

