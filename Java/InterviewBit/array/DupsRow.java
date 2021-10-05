package array;

import java.util.ArrayList;

/**
 * @author Kedar Erande
 */
public class DupsRow {
    public static void main(String[] args) {

    /*    int matrix[][] = {

                {1, 0, 0},
                {0, 1, 0},
                {0, 1, 0}
        };*/

        int matrix[][] = {

                {1, 1, 1, 0},
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {0, 0, 0, 1}
        };

        int result[] = getAllDups(matrix);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int[] getAllDups(int matrix[][]) {
        int j = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int index_to_compare = 0;
        boolean isEqual = false;
        for (int i = 0; i < matrix.length - 1; i++) {
            j = 0;
            index_to_compare = i + 1;
            while (j < matrix.length && index_to_compare < matrix.length) {

                int x = matrix[i][j];
                int y = matrix[index_to_compare][j];
                if (x == y) {
                    j = j + 1;
                    isEqual = true;
                } else {
                    index_to_compare++;
                    isEqual = false;
                }
            }
            if (isEqual == true) {
                arrayList.add(index_to_compare + 1);
            }
        }
        int arr[];
        arr = arrayList.stream().mapToInt(Integer::intValue).toArray();
        return arr;

    }
}
