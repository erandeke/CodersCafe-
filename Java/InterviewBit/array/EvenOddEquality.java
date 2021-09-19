package array;

/**
 * @author Kedar Erande
 *
 * PS: To calculcate the count of index such that sum of its odd and even are equal
 *
 * Approach: Cacl right even and right odd. If any of the element is removed then all the
 * elements to its right will be left shifted hence the even indices element will become odd and odd ones become evens
 *
 * by this formula : left odd+ right even == left even +right odd -> collect the count
 *
 * TC : O(n)
 */
public class EvenOddEquality {
    public static void main(String[] args) {
        //int A[] = {2, 1, 6, 4};
        int A[] = {1, 1, 1};
        System.out.println(getCount(A));
    }

    private static int getCount(int A[]) {
        int n = A.length;
        int re = 0;
        int ro = 0;
        int le = 0;
        int lo = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) {
                ro = ro + A[i];
            } else {
                re = re + A[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) {
                ro = ro - A[i];
            } else {
                re = re - A[i];
            }
            if (lo + re == le + ro) {
                count++;
            }
            if (i % 2 != 0) {
                lo = lo + A[i];
            } else {
                le = le + A[i];
            }
        }

        return count;

    }
}
