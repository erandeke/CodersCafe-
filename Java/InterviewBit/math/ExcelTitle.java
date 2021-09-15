package math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kedar Erande
 */
public class ExcelTitle {
    public static void main(String[] args) {
        System.out.println(getColnTitle(28));
    }

    private static String getColnTitle(int n) {
        HashMap<Integer,Character> hashMap = new HashMap<>();
        int mod = 0;
        StringBuilder sb = new StringBuilder();
        char c = 'A';
        for (int i = 0; i <= 25; i++) {
            hashMap.put(i, c++);
        }
        while (n != 0) {
            n = n - 1;
            mod = n % 26;

            sb.append(hashMap.get(mod).toString());
            n = n / 26;

        }

        return sb.toString();
    }
}
