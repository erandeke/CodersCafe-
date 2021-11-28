package sorting.problems;

/**
 * @author Kedar Erande
 */
public class SelectionSortOnSTrings {
    public static void main(String[] args) {
        String arr[] = {"GeeksforGeeks",
                "Practice.GeeksforGeeks",
                "GeeksQuiz"};
        performSelectionSortOnStrings(arr);
        for (String s : arr) {
            System.out.println(s);
        }
    }

    private static String[] performSelectionSortOnStrings(String[] str) {
        for (int i = 0; i < str.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < str.length; j++) {
                if (str[j].compareTo(str[min]) < 0) {
                    min = j;
                }
            }

            String temp = str[i];
            str[i] = str[min];
            str[min] = temp;


        }
        return str;
    }
}
