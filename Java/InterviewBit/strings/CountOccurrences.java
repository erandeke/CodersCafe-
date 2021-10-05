package strings;

/**
 * @author Kedar Erande
 * WAP to find the no of ocurrences in the string A for string "Bob"
 */
public class CountOccurrences {
    public static void main(String[] args) {

    }

    public int solve(String A) {
        int i=0;
        int count =0;
        while(i<A.length()-1){
            if(A.charAt(i)=='b' && A.charAt(i+1)== 'o' && A.charAt(i+2) == 'b')
            {
                count++;
                i=i+2;
            }
            else{
                i++;
            }
        }
        return count;
    }
}
