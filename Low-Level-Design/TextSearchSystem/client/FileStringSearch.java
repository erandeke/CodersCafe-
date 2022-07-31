package client;

public class FileStringSearch {


    public static void main(String[] args) {
        String text = "AAAABAAAA";
        String pattern = "AAA";
        int n = text.length();
        int m = pattern.length();
        int i = 0;
        int j = 0;
        int lps[] = new int[m];
        ComputeLpsService.computeLongestPrefix(m, lps, pattern);
        int counter = 0;
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                j = lps[j - 1];
                counter++;
                System.out.println("Pattern found at position ---> " + (i - j));
            } else if (i > 0 && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        //Print number of times pattern found in that file:
        System.out.println();
        System.out.println();
        System.out.println("count of------->" + "  " + "pattern" + " " + pattern + "is" + counter);

    }
}

