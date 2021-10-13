package array;

import java.util.Stack;

/**
 * @author Kedar Erande
 *
 * This is aboute finding the absolute path
 * Refer : https://www.geeksforgeeks.org/absolute-relative-pathnames-unix/
 */
public class PathRemoval {
    public static void main(String[] args) {

        //String A = "/a/./b/../../c/";
        String A = "/../";
        System.out.println(simplifyPath(A));
    }

    private static String simplifyPath(String A) {
        String folders[] = A.split("/");
        Stack<String> st = new Stack<>();
        for (String s : folders) {
            if (s.equals("") || s.equals("."))
                continue;
            else if (s.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else
                st.add(s);
        }

        StringBuilder sb = new StringBuilder();
        if (st.isEmpty()) {
            sb.append("/");
        }

        for (String s : st) {
            sb.append("/" + s);
        }


        return sb.toString();

    }
}
