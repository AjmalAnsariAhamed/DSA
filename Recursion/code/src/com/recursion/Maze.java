package com.recursion;

public class Maze {
    public static void main(String[] args) {
        System.out.println(count(3,3));

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
