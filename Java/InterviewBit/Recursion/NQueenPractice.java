package Recursion;

import java.util.ArrayList;

/**
 * @author Kedar Erande
 */
public class NQueenPractice {
    StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {

        ArrayList<ArrayList<String>> nqueens = new NQueenPractice().generateNQueenModel(4);
        System.out.println(nqueens);
    }

    private ArrayList<ArrayList<String>> generateNQueenModel(int A) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        char[][] board = new char[A][A];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        backTrackNQueen(0, res, board);

        return res;
    }

    private void backTrackNQueen(int row, ArrayList<ArrayList<String>> res, char[][] board) {
        if (row == board.length) {
            res.add(constructBoard(board));
            return;
        }

        //traverse column
        for (int c = 0; c < board.length; c++) {
            if (isPlacingQueenSafeAtCurrentPosition(row, c, board)) {
                board[row][c] = 'Q';
                backTrackNQueen(row + 1, res, board);
                board[row][c] = '.';
            }
        }


    }

    private boolean isPlacingQueenSafeAtCurrentPosition(int row, int col, char[][] board) {
        //Traverse to check if same column is occupied
        for (int i = 0; i <= row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        //Check if the left diagonal is occupied
        //both row and col will be decreasing
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //check  if the right diagonal is occupied
        //here row will be decreasing and column will be increasing
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }


    private ArrayList<String> constructBoard(char[][] board) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

}
