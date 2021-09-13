package math;

/**
 * @author Kedar Erande
 *
 * PS:  You are given an integer N and the task is to reverse the digits of the given integer. Return 0 if the result overflows and does not fit in a 32 bit signed integer
 *
 * TC : O(log base 10 (x) in each iteration we are didving the number by 10
 * sc: O(1)
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverseDigit(-1146467285));//This wil cause an overflow if you reverse as signed int cant hold the value
        //hence take into long and compared it against Int Max
        //System.out.println(reverseDigit(-123));
    }


    private static int reverseDigit(int n) {
        //convert the int to long and then it can be compared with singed int its greater than then return 0
        long x = n;
        boolean isNegtive = false;
        //here the negative check is to serve two purposes
        //1)To make the number positive and on reverse it can be compared against int max
        //2)If the number we didnt make positive then it will reverse and into some garbage value
        if(x < 0){
            x = 0 - x;
            isNegtive = true;
        }
        long result = 0;
        while (x != 0) {
            result = result * 10;
            result = result + x % 10;
            x = x / 10;

        }
        if (result > Integer.MAX_VALUE)
            return 0;
        return isNegtive  ? 0 - ((int)result) : (int)result;
    }

}
