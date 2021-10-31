package array.medium;

/**
 * @author Kedar Erande
 */
public class DeleteOneGCD {
    public static void main(String[] args) {
        //int arr[] = {9, 18, 49, 12, 30};
        int arr[] = {7, 21};
        int max = findMaxGCDOneDeletingAnyOneElement(arr);
        System.out.println(max);

    }

    private static int findMaxGCDOneDeletingAnyOneElement(int arr[]) {
        int prefixGcdArr[] = new int[arr.length];
        int suffixGcdArr[] = new int[arr.length];
        int max = Integer.MIN_VALUE;

        prefixGcdArr[0] = arr[0];
        suffixGcdArr[arr.length - 1] = arr[arr.length - 1];


        if (arr.length <= 2) {
            max = Math.max(arr[0], arr[1]);
            return max;
        }


        for (int i = 1; i < arr.length; i++) {
            prefixGcdArr[i] = gcd(prefixGcdArr[i - 1], arr[i]);
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            suffixGcdArr[i] = gcd(suffixGcdArr[i + 1], arr[i]);
        }

        for (int i = 1; i < arr.length - 1; i++) {
            max = Math.max(max, gcd(prefixGcdArr[i - 1], suffixGcdArr[i + 1]));
        }
        return max;
    }

    public static int gcd(int A, int B) {
        if (B == 0)
            return A; //since the gcd of any number with zero is  that number

        return gcd(B, A % B);

    }
}
