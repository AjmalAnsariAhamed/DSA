package com.recursion;
import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int r,int c,int[] arr){
        if(r==0){
            return;
        }
        if(c==r){
            bubbleSort(r-1,0,arr);
        }
        else{
            if(arr[c]>arr[c+1]){
                int temp=arr[c];
                arr[c]=arr[c+1];
                arr[c+1]=temp;
            }
            bubbleSort(r,c+1,arr);
        }
    }

    public static void main(String[] args) {
        int arr[]=new int[]{5,4,3,2,1};
        bubbleSort(arr.length-1,0,arr);
        System.out.println(Arrays.toString(arr));
    }
}
