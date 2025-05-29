package com.gfg;

import java.util.Arrays;

public class NextPermutation {
    static void reverse(int[] arr, int s, int e) {
        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }

    static void nextPermutation(int[] arr) {
        //[2, 4, 1, 7, 5, 0]
        int n = arr.length;
        int index = -1;
        int secLarge = 0;
        //[2, 4, 1, 7, 5, 0] will stop at 1 because
        // the very last permutation will [7,5,4,2,1,0] it is descending order and first permutation will be
        //[0,1,2,4,5,7] ascending order
        // from last to first then it shall be ascending
        //[2, 4, 1, 7, 5, 0] 0 -> 5 inc 5->7 inc 7-> 1 dec
        // at 1 element the order is breaking
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            reverse(arr, 0, n - 1);
            return;
        }
        // replace 1 with element just bigger than 1  like [11,--1--,10,7,6,3,--2--,0]
        // we need to replace with the 2
        // [2, 4, 1, 7, 5, 0]
        // we are finding 5
        for (int i = n - 1; i > index; i--) {
            if (arr[i] > arr[index]) {
                secLarge = i;
                break;
            }
        }
        // swap 1 with 5
        int temp=arr[index];
        arr[index]=arr[secLarge];
        arr[secLarge]=temp;
        //[2, 4, 5, 7, 1, 0]
        // is this the next permutation no X
        // [2, 4, 5, 0, 1, 7] this is the next permutation
        // simply reverse it from index+1 to n-1
        reverse(arr,index+1,n-1);

    }

    public static void main(String[] args) {
        int arr[]=new int[]{2, 4, 1, 7, 5, 0};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
