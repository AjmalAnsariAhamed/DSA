package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    public static void main(String[] args) {
boolean [][] maze=new boolean [][]{{true,true,true},{true,false,true},{true,true,true}};
        pathRestrictionsPrint("",maze,0,0);

    }
    static void pathList(String p, int r, int c, ArrayList<String> list){
        if(r==1&& c==1){
            list.add(p);
        }
        if(r>1){
            pathList(p+"R",r-1,c,list);
        }
        if(c>1){
            pathList(p+"D",r,c-1,list);
        }
    }
    static void pathPrint(String p, int r, int c){
        if(r==1&& c==1){
            System.out.println(p);
        }
        if(r>1){
            pathPrint(p+"R",r-1,c);
        }
        if(c>1){
            pathPrint(p+"D",r,c-1);
        }
    }
    static int count(int r, int c){
        if(r==1&& c==1){
            return 1;
        }
        int right=0,left=0;
        if(r>1){
           left= count(r-1,c);
        }
        if(c>1){
          right=  count(r,c-1);
        }
        return left+right;
    }
    static List<String> pathRetDiagonal(String p, int r,int c){
        if(r==1&& c==1){
            List<String>l=new ArrayList<>();
            l.add(p);
            return l;
        }
        List<String>ans=new ArrayList<>();
        if(r>1){
           ans.addAll( pathRetDiagonal(p+"R",r-1,c));
        }
        if(c>1){
            ans.addAll(pathRetDiagonal(p+"D",r,c-1));
        }
        if(r>1&&c>1){
            ans.addAll(pathRetDiagonal(p+"d",r-1,c-1));
        }
        return ans;
    }
    static void pathRestrictionsPrint(String p, boolean [][] maze,int r,int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r<maze.length-1){
            pathRestrictionsPrint(p+"R",maze,r+1,c);
        }
        if(c<maze[0].length-1){
            pathRestrictionsPrint(p+"D",maze,r,c+1);
        }
    }
}
