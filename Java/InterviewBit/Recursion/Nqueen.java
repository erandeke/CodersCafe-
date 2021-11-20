package Recursion;

import java.util.*;

/**
 * @author Kedar Erande
 */
public class Nqueen {
    private Set<Integer> col = new HashSet<>();
    private Set<Integer> posDiagonal = new HashSet<>();
    private Set<Integer> negativeDiagonal = new HashSet<>();

    public static void main(String[] args) {

        ArrayList<ArrayList<String>> list = new Nqueen().solveNQueens(4);
        System.out.println(list);
    }

    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        dfs(0, board, res);
        return res;
    }

    private boolean validate(char[][] board, int row, int col) {
        // vertical
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i] == 'Q') {
                return false;
            }
        }
        // diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private void dfs(int row, char[][] board, ArrayList<ArrayList<String>> res) {
        if (row == board.length) {
            res.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (validate(board, row, col)) {
                board[row][col] = 'Q';
                dfs(row + 1, board, res);
                board[row][col] = '.';
            }
        }
    }

    private ArrayList<String> construct(char[][] board) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }


}
