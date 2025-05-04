package com.recursion;

public class OneToN {
    public static void oneToN(int n,int i){
        if(i==n){
            System.out.println(i);
            return;
        }
        System.out.println(i);
        oneToN(n,i+1);
    }
    public static void nToOne(int n,int i){
        if(i==n){
            System.out.println(i);
            return;
        }

        nToOne(n,i+1);
        System.out.println(i);
    }
    public static void main(String[] args) {
        oneToN(10,1);
        System.out.println("********");
        nToOne(5,1);


    }
}
