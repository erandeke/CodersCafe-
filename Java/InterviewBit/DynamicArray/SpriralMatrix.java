package DynamicArray;

/**
 * @author Kedar Erande
 *
 * PS: Traverse the matrix like a sprial
 *
 * 1 --> 2
 *       |
 *       |
 * 4<--- 3
 * Tc: In worst case each cell needs to be visited twice A^2
 */
public class SpriralMatrix {
    public static void main(String[] args) {

        int B[][] = get2DMatrix(6);
        for (int i = 0; i < B.length; i++)
            for (int j = 0; j < B.length; j++) {
                System.out.println(B[i][j]);
                System.out.println();
            }

    }

    public static int[][] get2DMatrix(int A) {
        int[][] B = new int[A][A];
        int K = 1;
        int dir = 0;
        int rc = 0;
        int cl = 0;
        while (K <= A * A) {
            B[rc][cl] = K;
            K = K + 1;
            if (dir == 0) {
                cl++;
                if (cl == A || B[rc][cl] != 0) {
                    rc++;
                    dir = 1;
                    cl--;
                }
            } else if (dir == 1) {
                rc++;
                if (rc == A || B[rc][cl] != 0) {
                    cl--;
                    dir = 2;
                    rc--;
                }
            } else if (dir == 2) {
                cl--;
                if (cl < 0 || B[rc][cl] != 0) {
                    dir = 3;
                    rc--;
                    cl++;
                }
            } else if (dir == 3) {
                rc--;
                if (rc < 0 || B[rc][cl] != 0) {
                    rc++;
                    cl++;
                    dir = 0;
                }

            }

        }
        return B;
    }
}
