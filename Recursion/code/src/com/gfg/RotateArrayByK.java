package com.gfg;

import java.util.Arrays;

public class RotateArrayByK {
    public static void main(String[] args) {
        // Output the result of modulo operations: 8 % 6 = 2 and 2 % 2 = 2
        // if k goes beyond the size of array then
        System.out.println(8 % 6 + " " + 2 % 6); // Output: 2 2

        // Declare and initialize an array
        int arr[] = {1, 2, 3, 4, 5, 6};

        // Rotate the array by k = 8 positions to the left
        rotatingArrayByK(arr, 8);

        // Print the rotated array
        System.out.println(Arrays.toString(arr)); // Output: [3, 4, 5, 6, 1, 2]
    }

    /**
     * Reverses the elements in the array from index 's' to index 'e'.
     */
    static void reverse(int array[], int s, int e) {
        while (s < e) {
            // Swap elements at positions s and e
            int temp = array[s];
            array[s] = array[e];
            array[e] = temp;
            s++;
            e--;
        }
    }

    /**
     * Rotates the array to the left by 'k' positions using the reversal algorithm.
     * Steps:
     * 1. Reverse the first 'k' elements.
     * 2. Reverse the remaining 'n-k' elements.
     * 3. Reverse the whole array.
     *
     * For left rotation by k:
     * Original:   [1, 2, 3, 4, 5, 6]
     * Step 1:     [2, 1, 3, 4, 5, 6]
     * Step 2:     [2, 1, 6, 5, 4, 3]
     * Step 3:     [3, 4, 5, 6, 1, 2]
     */
    static void rotatingArrayByK(int arr[], int k) {
        // Normalize k if greater than array length
        k = k % arr.length;

        // Reverse first k elements
        reverse(arr, 0, k - 1);

        // Reverse remaining elements
        reverse(arr, k, arr.length - 1);

        // Reverse the entire array
        reverse(arr, 0, arr.length - 1);
    }
}
