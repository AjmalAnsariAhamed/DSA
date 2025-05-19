package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze {
    public static void main(String[] args) {
boolean [][] maze=new boolean [][]{{true,true,true},{true,true,true},{true,true,true}};
        allPathsPrintArrayWithBackTrack("",maze,0,0,1,new int[][]{{0,0,0},{0,0,0},{0,0,0}});

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
    static void allPathsPrint(String p, boolean [][] maze,int r,int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }

        if(r<maze.length-1){
            allPathsPrint(p+"R",maze,r+1,c);
        }
        if(c<maze[0].length-1){
            allPathsPrint(p+"D",maze,r,c+1);
        }
        if(r>0){
            allPathsPrint(p+"U",maze,r-1,c);
        }
        if(c>0){
            allPathsPrint(p+"L",maze,r,c-1);
        }
    }
    static void allPathsPrintWithBackTrack(String p, boolean [][] maze,int r,int c){
        // Base case: If the current cell is the destination (bottom-right corner)
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p); // Print the current path
            return; // Exit this path
        }

        // If the current cell is blocked or already visited, return immediately
        if (!maze[r][c]) {
            return;
        }

        // Mark the current cell as visited by setting it to false
        maze[r][c] = false;

        // Move Down (R): Only if not at the last row
        if (r < maze.length - 1) {
            allPathsPrintWithBackTrack(p + "R", maze, r + 1, c);
        }

        // Move Right (D): Only if not at the last column
        if (c < maze[0].length - 1) {
            allPathsPrintWithBackTrack(p + "D", maze, r, c + 1);
        }

        // Move Up (U): Only if not at the first row
        if (r > 0) {
            allPathsPrintWithBackTrack(p + "U", maze, r - 1, c);
        }

        // Move Left (L): Only if not at the first column
        if (c > 0) {
            allPathsPrintWithBackTrack(p + "L", maze, r, c - 1);
        }

        // Backtrack: Unmark the current cell so it can be used in other paths
        maze[r][c] = true;
    }
    /**
     * Prints all possible paths from top-left to bottom-right in a maze,
     * along with the step number at each cell in the path.
     * This uses backtracking to explore all directions (down, right, up, left).
     *
     * @param p           The path taken so far (as a string of directions).
     * @param maze        The boolean maze grid where true means a cell is available.
     * @param r           Current row.
     * @param c           Current column.
     * @param step        Current step count (used to populate the path grid).
     * @param printArray  2D array used to store and print the path with step numbers.
     */
    public static void allPathsPrintArrayWithBackTrack(String p, boolean[][] maze, int r, int c, int step, int[][] printArray) {

        // Base condition: reached the bottom-right cell (goal)
        if (r == maze.length - 1 && c == maze[r].length - 1) {
            printArray[r][c] = step;  // Mark the final step

            // Print the path matrix showing step numbers
            for (int[] i : printArray) {
                System.out.println(Arrays.toString(i));
            }

            // Print the direction string (path)
            System.out.println(p);
            return;
        }

        // If the current cell is already visited or blocked
        if (!maze[r][c]) {
            return;
        }

        // Mark the cell as visited
        maze[r][c] = false;
        printArray[r][c] = step;

        // Explore downward
        if (r < maze.length - 1) {
            allPathsPrintArrayWithBackTrack(p + "D", maze, r + 1, c, step + 1, printArray);
        }

        // Explore rightward
        if (c < maze[r].length - 1) {
            allPathsPrintArrayWithBackTrack(p + "R", maze, r, c + 1, step + 1, printArray);
        }

        // Explore upward
        if (r > 0) {
            allPathsPrintArrayWithBackTrack(p + "U", maze, r - 1, c, step + 1, printArray);
        }

        // Explore leftward
        if (c > 0) {
            allPathsPrintArrayWithBackTrack(p + "L", maze, r, c - 1, step + 1, printArray);
        }

        // Backtrack: unmark the cell for other paths
        maze[r][c] = true;
        printArray[r][c] = 0;
    }

}
