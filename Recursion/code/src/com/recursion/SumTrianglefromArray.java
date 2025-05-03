package com.recursion;

import java.util.Arrays;

public class SumTrianglefromArray {
    public static  void printArray(int a[]){
        if(a.length<1){
            return;
        }
        int temp[]= new int[a.length-1];
        for(int i=0;i<temp.length;i++){
            temp[i]=a[i]+a[i+1];
        }
        printArray(temp);
        System.out.println(Arrays.toString(a));
    }

   public static void main(String [] args){
       System.out.println("Sum Triangle from Array");
       printArray(new int[]{1,2,3,4,5,6});
   }
}
