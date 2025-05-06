package com.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Leetcode17 {
    public static List<String> letterCombination(String p, String str) {
        if (str.isEmpty()) {

            List<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        List<String> list=new ArrayList<>();
        int digit=str.charAt(0)-'0';
        digit='a'+(digit-2)*3;
        for (int i = digit; i <digit+3 ; i++) {
            list.addAll(letterCombination(p+(char)i,str.substring(1)));

        }
        return list;

    }
    static Map<Character, String> phoneMap = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );
    public static List<String>letterCombo(List<String> list,String p,String digits){
        if(digits.isEmpty()){
            list.add(p);
            return list;
        }
        String num=phoneMap.get(digits.charAt(0));
        for(char ch:num.toCharArray()){
             letterCombo(list,p+ch,digits.substring(1));
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(letterCombo(new ArrayList<String>(),"","23"));
    }
}
