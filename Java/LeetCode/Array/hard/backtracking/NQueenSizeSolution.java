package Array.hard.backtracking;

import java.util.ArrayList;

/**
 * @author Kedar Erande
 *
 * LeetCode Problem : https://leetcode.com/problems/n-queens-ii/
 */
public class NQueenSizeSolution {
    int ans = 0;

    public static void main(String[] args) {
        System.out.println(new NQueenSizeSolution().totalNQueens(4));

    }

    public int totalNQueens(int n) {
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            board.add(list);
            for (int j = 0; j < n; j++) {
                list.add(0);
            }
        }
        ans = backTrack(ans, board, 0);
        return ans;
    }

    private int backTrack(int ans, ArrayList<ArrayList<Integer>> board, int row) {
        ans = 0;
        if (row == board.size()) {
            return 1;

        }

        //traverse coln
        for (int col = 0; col < board.size(); col++) {
            if (isValid(row, col, board)) {
                board.get(row).set(col, 1);
                ans = ans + backTrack(ans, board, row + 1);
                //backTrack....
                board.get(row).set(col, 0);
            }
        }
        return ans;

    }


    private boolean isValid(int row, int col, ArrayList<ArrayList<Integer>> board) {
        //traverse row
        for (int i = 0; i <= row; i++) {
            if (board.get(i).get(col) == 1) {
                return false;
            }
        }

        //traverse left diag
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).get(j) == 1) {
                return false;
            }
        }

        //traverse right diagonal

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.size(); i--, j++) {
            if (board.get(i).get(j) == 1) {
                return false;
            }
        }

        return true;


    }

}
