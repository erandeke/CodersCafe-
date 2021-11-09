package CP.misc;

/**
 * @author Kedar Erande
 */
public class StorageInt {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        int a = (1<<31)-1; // This will not cause overflow
        //we cannot take 2e32 to store in int since 1 bit is reserved for signed + or - hence
        //it will overflow if we do 1 << 32
        System.out.println(a);

        /* But in case of unsigned it will be able to hold  */
       Integer b = (1<<32)-1;
        System.out.println(b);



    }

}
