package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Kedar Erande
 * <p>
 * //This code is optmisation on the isValid condition instead of traversing each coln , each left right diaognal
 * //we just need to maintain the left diaogonal visited, right diagonal visited and column visited
 * // why because  sum and difference of row and coloumn are constant that gives us the lead
 * //if we consider left diaognal then r-c will be constant and of we consider right diagonal then r+c will be constant hence we need to just maintain the sets and check
 * //for the valid place
 */
public class NqueenOptimise {
    Set<Integer> visitedColumns = new HashSet<>();
    Set<Integer> visitedLeftDiagonals = new HashSet<>();
    Set<Integer> visitedRightDiagonals = new HashSet<>();

    public static void main(String[] args) {
        new NqueenOptimise().generateNQueenModel(4);
    }

    private ArrayList<ArrayList<String>> generateNQueenModel(int A) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        char board[][] = new char[A][A];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        backTrack(0, res, board);
        return res;
    }

    private void backTrack(int row, ArrayList<ArrayList<String>> res, char[][] board) {
        if (row == board.length) {
            res.add(constructBoard(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (visitedColumns.contains(col) || visitedLeftDiagonals.contains(row - col) || visitedRightDiagonals.contains(row + col)) {
                continue;
            }
            visitedColumns.add(col);
            visitedLeftDiagonals.add(row - col);
            visitedRightDiagonals.add(row + col);
            board[row][col] = 'Q';
            backTrack(row + 1, res, board);
            //backtracking starts
            board[row][col] = '.';
            visitedColumns.remove(col);
            visitedLeftDiagonals.remove(row - col);
            visitedRightDiagonals.remove(row + col);
        }


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
