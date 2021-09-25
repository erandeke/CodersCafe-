package array;

/**
 * @author Kedar Erande
 * <p>
 * PS: Input:
 * N = 5, D = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
 * <p>
 * Return: [10, 55, 45, 25, 25]
 * <p>
 * Explanation:
 * => First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]
 * <p>
 * => Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]
 * <p>
 * => Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]
 * <p>
 * TC : n*m-1
 */
public class BeggarProblem {

    //Approach:
    /*
    i=1->N
    result : 0 -> N;

    C[] = B.get(i);
    for C=C[o] -> C.length
    result[C] = 10, 10

   for i=2 , i<B,lengthli++)
     C= b.get(2);

     C= 2, 3 , 20
     for(i=C[o]->C.length-1]
     result[C[i]+C[C.end] = result[2],==> 30
     //for 3,
     20

          */

    public static void main(String[] args) {

        int N = 5;
        int B[][] = {
                {1, 2, 10},
                {2, 3, 20},
                {2, 5, 25}
        };

        int result[] = solve(N, B);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }


    public static int[] solve(int A, int[][] B) {

        int result[] = new int[A];
        //filled with zeros
        for (int i = 0; i < A; i++) {
            result[i] = 0;
        }

        int sum = 0;
        int prev_pointer = 0;
        for (int i = 0; i < B.length; i++) {
            //get the first d array
            int C[] = B[i];
            int start = C[0] - 1;  // first element start
            int end = C[C.length - 2]; // end till C will be traversed
            int amount = C[C.length - 1]; // amount to be donated
            prev_pointer = start;//this is to add the amount to the previous beggars

            for (int k = start; k < end; k++) {
                result[prev_pointer] = amount + result[prev_pointer];
                prev_pointer++;
                if (prev_pointer > result.length - 1)
                    break;

            }
        }

        return result;
    }

}
