package com.gfg;

import java.util.Arrays;

public class NonRepeatingCharacter {
    public static final int maxChar=26;
    public char nonRepeatingChar(String s) {
        // code here
        int [] vis= new int [maxChar];
        Arrays.fill(vis,-1);

        for(int i=0;i<s.length();i++){
            int index=s.charAt(i)-'a';
            if(vis[index]==-1){
                vis[index]=i;
            }else{
                vis[index]=-2;
            }
        }
        // vis stores the -2 or -1 for repeating char and stores index for non-repeating char
        int ind=-1;
        for(int i=0;i<maxChar;i++){
            if(vis[i]>=0 && (ind==-1 || vis[i]<ind)){
                //if ind has 5(represents the char index in s string )) and now vis[i] has 2 2 comes before 3
                ind=vis[i];
            }
        }

return ind ==-1 ?'$':s.charAt(ind);
    }

    public static void main(String[] args) {
        String v="hello";
        NonRepeatingCharacter ob= new NonRepeatingCharacter();
        System.out.println(ob.nonRepeatingChar(v));
    }
}
