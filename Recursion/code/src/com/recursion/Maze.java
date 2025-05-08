package com.recursion;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
     ArrayList<String> list= new ArrayList<>();
     countList("",3,3,list);
        System.out.println(list);

    }
    static void countList(String p, int r, int c, ArrayList<String> list){
        if(r==1&& c==1){
            list.add(p);
        }
        if(r>1){
            countList(p+"R",r-1,c,list);
        }
        if(c>1){
            countList(p+"D",r,c-1,list);
        }
    }
    static void countPrint(String p, int r, int c){
        if(r==1&& c==1){
            System.out.println(p);
        }
        if(r>1){
            countPrint(p+"R",r-1,c);
        }
        if(c>1){
            countPrint(p+"D",r,c-1);
        }
    }
    static int count(int r, int c){
        if(r==1&& c==1){
            return 1;
        }
        int right=0,left=0;
        if(r>1){
           left= count(r-1,c);
        }
        if(c>1){
          right=  count(r,c-1);
        }
        return left+right;
    }
}
