package array.medium;

/**
 * @author Kedar Erande
 *
 * PS: A lucky number is a number which has exactly 2 distinct prime divisors.
 *
 * You are given a number A and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).
 *
 * TC - Sieve TC
 * Approach : Construct the count array having prime divisors -
 * Initailize the array with 0 if found factors then make the count as 1 for their factors that means it's factors
 * are non prime and cannot be considered for for iteration
 * Example
 * 2 4 6
 * Now initaly cnt[2] = 0 on multplying to find it factors we will make cnt[4]=1 and cnt[6]=1
 * Now comes 3 so is it Prime cnt[3]= 0 hence go ahead and increment its factors
 * now comes 4 is it prime no since 2 has got its divisor
 * consider 6 -> we have count as 2 now since it got 2 prime divisors 2 and 3
 * similary for 10 ->2,5 and 12 -> 2, 3
 *
 */
public class LuckyNumber {
    public static void main(String[] args) {

        System.out.println(getTheLuckNumbers(6));
    }

    private static int getTheLuckNumbers(int A) {
        int count = 0;

        int cnt[] = new int[A + 1];


        for (int i = 2; i <= A; i++) {
            if (cnt[i] == 0) {
                for (int p = i * 2; p <= A; p = i + p) {
                    cnt[p]++;
                }
            }
        }

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 2) {
                count++;
            }
        }

        return count;
    }
}
