package com.yyp.luogu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1042 {
    static class score{
        private int win, loss;
        public score(int win, int loss){
            this.win = win;
            this.loss = loss;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //每轮
        int win11 = 0, loss11 = 0, win21 = 0, loss21 = 0;
        int count = 0;
        List<score> scoreList11 = new ArrayList<>();
        List<score> scoreList21 = new ArrayList<>();
        while (sc.hasNextLine()){
            String substr = sc.next();
            boolean sign = false;
            for (int i = 0; i < substr.length(); i++){
                count++;
                if(substr.charAt(i) == 'W'){
                    win11++;
                    win21++;
                }else if(substr.charAt(i) == 'L') {
                    loss11++;
                    loss21++;
                } else if(substr.charAt(i) == 'E'){
                    sign = true;
                }
                //赢得一方比分必须达到11或21分，且与对手的比分差距大于等于2，若比分差距未大于等于2，则要继续比赛知道满足条件
                if (win11 >= 11 && win11 > loss11 && win11 - loss11 >=2 || loss11 >= 11 && loss11 > win11 && loss11 - win11 >= 2 || sign){
                    scoreList11.add(new score(win11, loss11));
                    //重置
                    win11 = 0;
                    loss11 = 0;
                }
                if (win21 >= 21 && win21 > loss21 && win21 - loss21 >=2 || loss21 >= 21 && loss21 > win21 && loss21 - win21 >= 2 || sign){
                    scoreList21.add(new score(win21, loss21));
                    //重置
                    win21 = 0;
                    loss21 = 0;
                }
                if (sign){
                    break;
                }
            }
            if (sign){
                break;
            }
        }

        for (int i = 0; i < scoreList11.size(); i++){
            System.out.println(scoreList11.get(i).win + ":" + scoreList11.get(i).loss);
        }
        System.out.println();
        for (int i = 0; i < scoreList21.size(); i++){
            System.out.println(scoreList21.get(i).win + ":" + scoreList21.get(i).loss);
        }
        sc.close();
    }
}

