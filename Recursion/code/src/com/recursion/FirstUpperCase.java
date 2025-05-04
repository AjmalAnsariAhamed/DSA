package com.recursion;

public class FirstUpperCase {
    public static char firstUpperCase(String s, int i){
        if(i>=s.length()){
            return '\0';
        }
        if(Character.isUpperCase(s.charAt(i))){
            return s.charAt(i);
        }
        else{
            return firstUpperCase(s,i+1);
        }
    }
    public static void main(String[] args) {
        System.out.println(firstUpperCase("geeksForgeeks",0));
    }
}
