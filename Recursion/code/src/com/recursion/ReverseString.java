package com.recursion;

import java.util.Arrays;

public class ReverseString {
    public static void reverseString(char [] s,int i){
        if(i>=s.length-i-1){
            return;
        }

        char temp=s[s.length-i-1];

        s[s.length-i-1]=s[i];
        s[i]=temp;
        reverseString(s,i+1);
    }

    public static void main(String[] args) {
        char [] ch={'H','e','l','l','o'};
        reverseString(ch,0);
        System.out.println(Arrays.toString(ch));
    }
}
