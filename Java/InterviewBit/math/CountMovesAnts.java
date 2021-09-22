package math;

/**
 * @author Kedar Erande
 *
 * PS: Find the last ant to fall off the plank
 * Approach : lets say B ants are traversing left and C ants are traversing right
 * then its by obervation ants travelling to right we need to find minimum ith ant that will take time
 * to reach till length of the plank
 * and for left traversal we need to find max ith ant that will take time to fall off the plank
 * Example:
 * B[3,4]  C[0,1];
 * lets say length given is 4
 * then for C ants we need to find min element and then subtract it from the A to find the time taken
 * and for B ants traversing left we  need to find the max ith ant to traverse till 0 to get he time
 * then final ans will be max of both (left , right) traversal
 *
 */
public class CountMovesAnts {
    public static void main(String[] args) {
   /*
   A : 4
B : [ 1 ]
C : [  ]

    */
        int A = 9;
        int B[] = {5};
        int C[] = {4};
        System.out.println(C.length);

        int x = new CountMovesAnts().solve(A, B, C);
        System.out.println(x);

    }

    public int solve(int A, int[] B, int[] C) {
        int min_right = A;
        int max_left = 0;
        for (int i : C) {
            min_right = Math.max(min_right, i);
        }
        for (int i : B) {
            max_left = Math.max(max_left, i);
        }

        return Math.max(max_left, A - min_right);

    }
}
