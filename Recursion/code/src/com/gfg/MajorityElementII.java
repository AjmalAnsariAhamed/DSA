package com.gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementII {
    static List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 1) {
            return new ArrayList<>();
        }
        int elem1 = 0, elem2 = 0;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && elem2 != nums[i]) {
                elem1 = nums[i];
            }
            if (count2 == 0 & elem1 != nums[i]) {
                elem2 = nums[i];
            }
            if (elem1 == nums[i]) {
                count1++;
            }
            if (elem2 == nums[i]) {
                count2++;
            }
            if (nums[i] != elem1 && nums[i] != elem2) {
                count1--;
                count2--;
            }

        }
        if(count2>count1){
            int temp=elem1;
            elem1=elem2;
            elem2=temp;
        }
        return new ArrayList<>(Arrays.asList(elem1, elem2));
    }
    // this is the correct version 
    static List<Integer> majorityElement2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int elem1 = 0, elem2 = 0, count1 = 0, count2 = 0;

        // Step 1: Find potential candidates
        for (int num : nums) {
            if (num == elem1) {
                count1++;
            } else if (num == elem2) {
                count2++;
            } else if (count1 == 0) {
                elem1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                elem2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify the candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == elem1) count1++;
            else if (num == elem2) count2++;
        }

        int n = nums.length;
        if (count1 > n / 3) result.add(elem1);
        if (count2 > n / 3) result.add(elem2);
        if(result.size()==2 && result.get(0)>result.get(1)){
            int temp=result.get(0);
            result.set(0,result.get(1));
            result.set(1,temp);
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,1,1,1,3,3,3,1,1,2,2,2,2,2,1,4,4,4,4,4,4,4,4,4,5}));
    }
}
