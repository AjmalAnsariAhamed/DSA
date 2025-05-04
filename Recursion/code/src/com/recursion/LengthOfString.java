package com.recursion;

public class LengthOfString {
    public static int lengthOfString(String str){
        if(str.equals("")){
            return 0;
        }
        else{
            return lengthOfString(str.substring(1,str.length()))+1;
        }
    }

    public static void main(String[] args) {
        System.out.println(lengthOfString("King of pirates"));
    }
}
