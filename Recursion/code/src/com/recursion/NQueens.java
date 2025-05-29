package com.recursion;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        //nQueens(board, 0);
        System.out.println(nQueensCount(board,0));


    }

    static void nQueens(boolean[][] board, int r) {
        if (r == board.length) {
            display(board);
            System.out.println("-------------*************------------");
            return;
        }

        for (int c = 0; c < board[r].length; c++) {
            //System.out.println(c+"  "+r);
            if (isSafe(board, r, c)) {
                board[r][c] = true;
                nQueens(board, r + 1);
                board[r][c] = false;
            }
        }
    }

    static int nQueensCount(boolean[][] board, int r){
        if(r==board.length){
            display(board);
            System.out.println('\n');
            return 1;
        }
        int count =0;
        for(int c =0;c<board.length;c++){
            if(isSafe(board,r,c)){
                board[r][c]=true;
               count+= nQueensCount(board,r+1);
                board[r][c]=false;
            }
        }
        return count;
    }

    static boolean isSafe(boolean[][] board, int r, int c) {
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c]) {
                return false;
            }
        }

        // left horizontal check
        // ieration times = min(r,c)
        int maxLeft = Math.min(r, c);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[r - i][c - i]) {
                return false;
            }
        }
        int maxRight = Math.min(r, board.length - 1 - c);
        for (int i = 1; i <= maxRight; i++) {
            if (board[r - i][c + i]) {
                return false;
            }
        }
        return true;
    }

    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean piece : row) {
                if (piece) {
                    System.out.print(" Q ");
                } else {
                    System.out.print(" X ");
                }
            }
            System.out.println();
        }
    }
}
