package CP.bits;

/**
 * @author Kedar Erande
 */
public class BitsManipulation {
    public static void main(String[] args) {

        printBinary(2);
        System.out.println();
        System.out.println(isOddOrEven(4));//even
        System.out.println(rightShift(4));//2
        System.out.println(leftShift(4));//8
        System.out.println(getTheLowerCase('A'));//a
        System.out.println(getTheUpperCase('a'));//A
        //set the bit at the particular position
        System.out.println();
        printBinary(setTheIthBit(9));//11
        //unset the bit at the particular position
        System.out.println();
        printBinary(unsetTheIthBit(9));//8
        //clearMsb
        System.out.println();
        printBinary(59);
        System.out.println();;
        printBinary(clearMsb(59));
        System.out.println();
        printBinary(11);
        System.out.println();
        printBinary(clearMsb(11));

    }

    private static void printBinary(int n) {
        for (int i = 10; i >= 0; i--) {
            System.out.print((n >> i) & 1);
        }
    }

    //program to check if the number is odd or even
    private static String isOddOrEven(int n) {
        if ((n & 1) != 0) {
            return "odd";
        }
        return "even";
    }

    private static int rightShift(int n) {
        //divide
        int x = n >> 1;
        return x;

    }

    private static int leftShift(int n) {
        //divide
        int x = n << 1;
        return x;

    }

    private static char getTheLowerCase(char C) {
        //intution here is
        /*
           'A' -> 100001 5th bit is always unset for upper case characters
           'a' -> 110001 5th bit is always set of lower case characters
           hence set the 5th bit here since we want to generate lower case
         */
        char lower_case = (char) (C | (1 << 5));
        return lower_case;

    }

    private static char getTheUpperCase(char C) {
        //intution here is
        /*
           'A' -> 100001 5th bit is always unset for upper case characters
           'a' -> 110001 5th bit is always set of lower case characters
           hence unset the 5th bit here since we want to generate upper case
         */
        char upper_case = (char) (C & (~(1 << 5)));
        return upper_case;

    }

    private static int setTheIthBit(int n) {
        int i = 1;
        int ans = n | (1 << i);
        System.out.println(ans);
        return ans;
    }

    private static int unsetTheIthBit(int n) {
        int i = 0;
        int ans = (n & (~(1 << i)));
        return ans;
    }

    private static int clearMsb(int n)
    {
        int i=2;
        //int ans = n & (~((1<<i+1)-1));
        int ans = n&(1<<(i+1));
        return ans;
        //below is the dry run
    }


    /*

      Various Dry Runs :

    1)Left shift 4 << i where i = 1
    ans 4* 2e1=8

    0100 << 2e1 = shift bits to the left that will rose to 1000 and hence the ans is 8

    2)Right Shift 4 >> i where i =1
    ans 4 / 2e1 = 2
    0100 -> 0010 -> 4/2 -> 2

    3)Set bit at i=1 for a=4
    4 | (1<<i)
    = 0100 | (0010)
    = 0110

    4)Unset bit at i=0 for a=9
    binary for a=9 -> 1001
    formula : a & (~(1<<i)
    1001 & (~(0001))
    1001 & (1000)
    1000- ans

    5)How to toggle the bit at prticular place :
    -Use XOR
     x ^ (1<<i)

    6)Count number of set bits :
    for(int i=0;i<=31;i++)
    {
    if(x& (1<<i) !=0)
    {
    count++;
    }

    7)Clear MSB
    111011 -> 59
    after clearing 4th bit MSB ans should be 100000
    Now how to obtain that number :

    we can have left shitf 1<<(i+1) -> since 4th bit from 0 is 5 therefore 1<<5 will be 10000



     */
}
