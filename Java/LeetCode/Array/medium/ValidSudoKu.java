package Array.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Kedar Erande
 */
public class ValidSudoKu {
    public static void main(String[] args) {

        char[][] board = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.' },
                {'.', '4', '.', '3', '.', '.', '.', '.', '.' },
                {'.', '.', '.', '.', '.', '3', '.', '.', '1' },
                {'8', '.', '.', '.', '.', '.', '.', '2', '.' },
                {'.', '.', '2', '.', '7', '.', '.', '.', '.' },
                {'.', '1', '5', '.', '.', '.', '.', '.', '.' },
                {'.', '.', '.', '.', '.', '2', '.', '.', '.' },
                {'.', '2', '.', '9', '.', '.', '.', '.', '.' },
                {'.', '.', '4', '.', '.', '.', '.', '.', '.' }


        };


        System.out.println(isValidConfig(board,board.length));
    }

    public static boolean notInRow(char arr[][], int row) {

        // Set to store characters seen so far.
        HashSet<Character> st = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            // If already encountered before,
            // return false
            if (st.contains(arr[row][i]))
                return false;

            // If it is not an empty cell, insert value
            // at the current cell in the set
            if (arr[row][i] != '.')
                st.add(arr[row][i]);
        }
        return true;
    }

    // Checks whether there is any duplicate
// in current column or not.
    public static boolean notInCol(char arr[][], int col) {
        HashSet<Character> st = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            // If already encountered before,
            // return false
            if (st.contains(arr[i][col]))
                return false;

            // If it is not an empty cell,
            // insert value at the current
            // cell in the set
            if (arr[i][col] != '.')
                st.add(arr[i][col]);
        }
        return true;
    }

    // Checks whether there is any duplicate
// in current 3x3 box or not.
    public static boolean notInBox(char arr[][],
                                   int startRow,
                                   int startCol) {
        HashSet<Character> st = new HashSet<>();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char curr = arr[row + startRow][col + startCol];

                // If already encountered before, return
                // false
                if (st.contains(curr))
                    return false;

                // If it is not an empty cell,
                // insert value at current cell in set
                if (curr != '.')
                    st.add(curr);
            }
        }
        return true;
    }

    // Checks whether current row and current column and
// current 3x3 box is valid or not
    public static boolean isValid(char arr[][], int row,
                                  int col) {
        return notInRow(arr, row) && notInCol(arr, col) &&
                notInBox(arr, row - row % 3, col - col % 3);
    }

    public static boolean isValidConfig(char arr[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // If current row or current column or
                // current 3x3 box is not valid, return
                // false
                if (!isValid(arr, i, j))
                    return false;
            }
        }
        return true;
    }
}
