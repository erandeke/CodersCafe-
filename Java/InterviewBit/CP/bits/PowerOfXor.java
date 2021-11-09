package CP.bits;

/**
 * @author Kedar Erande
 */
public class PowerOfXor {
    public static void main(String[] args) {
        swap(10,11);
    }

    private static void swap(int a,int b)
    {
        a=a^b;
        b=b^a;
        a=a^b;
        System.out.println(a+"  "+b);
    }
}
