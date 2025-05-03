package com.recursion;

public class MaxMinNum {
    public static int maximumNumber(int arr [], int n){
       if(n== arr.length-1){
           return arr[arr.length-1];
       }
        return Math.max(arr[n],maximumNumber(arr,n+1));
    }
    public static int minimumNumber(int arr [], int n){
        if(n== arr.length-1){
            return arr[arr.length-1];
        }
        return Math.min(arr[n],minimumNumber(arr,n+1));
    }
    public static void main(String[] args) {
        System.out.println(maximumNumber(new int[]{1,2,3,4,5,-2,6},0)+" max number");
        System.out.println(minimumNumber(new int[]{1,-2,2,3,4,5,},0)+" min number");



    }
}
