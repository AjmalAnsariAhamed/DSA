package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    public static void dice(String ans,int num){
        if(num==0){
            System.out.println(ans);
            return;
        }
        for(int i=1;i<=num;i++){
            dice(ans+i,num-i);
        }
    }
    public static List<String> dice1(List<String>anslist,String ans, int num){
        if(num==0){
            anslist.add(ans);
            return anslist;
        }
        for(int i=1;i<=num;i++){
            dice1(anslist,ans+","+i,num-i);
        }
        return anslist;
    }
    public static int diceCount(String ans, int num){
        if(num==0){
            return 1;
        }
        int count =0;
        for(int i=1;i<=num;i++){
          count+=diceCount(ans+","+i,num-i);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(diceCount("",4));
    }
}
