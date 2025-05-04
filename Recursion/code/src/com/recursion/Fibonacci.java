package com.recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    static Map<Integer,Integer>memo=new HashMap<>();
    public static int fibonacci(int n){
        if(n<=1){
            return n==1?1:0;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int result=fibonacci(n-1)+fibonacci(n-2);
        memo.put(n,result);
        return result;
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(5));

    }
}
