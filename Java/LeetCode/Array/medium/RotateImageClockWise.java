package Array.medium;

/**
 * @author Kedar Erande
 */
public class RotateImageClockWise {

    private void rotateImage(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }

    private void reverse(int[][] matrix) {
        //for each row start swapping using two pointer approach
        for (int row = 0; row < matrix.length; row++) {
            int i = 0;
            int j = matrix[i].length - 1;
            while (i < j) {
                int temp = matrix[row][i];
                matrix[row][i] = matrix[row][j];
                matrix[row][j] = temp;
                i++;
                j--;
            }
        }

    }

    public static void main(String[] args) {

        RotateImageClockWise rotateImageClockWise = new RotateImageClockWise();
        int[][] matrix =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };
        rotateImageClockWise.reverse(matrix);

    }
}
