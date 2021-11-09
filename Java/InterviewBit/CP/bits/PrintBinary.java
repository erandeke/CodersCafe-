package CP.bits;

/**
 * @author Kedar Erande
 */
public class PrintBinary {
    public static void main(String[] args) {
        printBinary(20);
    }

    private static void printBinary(int n) {
        for (int i = 5; i >= 0; i--) {
            System.out.print((n >> i) & 1);
        }
    }

    /*
     DRY RUN

     i=3

     4 >> 3 --> 4 / 2e3 -> 0  & 1 //0

     i= 2
     4 >> 2 --> 4/2e2 --> 1 & 1 // 1

     i=1

     4>>1 --> 4/2e1 --> 2 & 1 // 0

     i=0 --> 0

     hence for 4 -> 0100



     */
}
