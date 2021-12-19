package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Kedar Erande
 * https://leetcode.com/problems/repeated-dna-sequences/
 */
public class DNASequence {
    public static void main(String[] args) {

        String s = "AAAAAAAAAAAAA";
        String s1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> list = findRepeatedDnaSequences(s1);
        System.out.println(list);

    }

    public static List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> hm = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String tem = s.substring(i, i + 10);
            hm.put(tem, hm.getOrDefault(tem, 0) + 1);
        }
        for (String str : hm.keySet())
            if (hm.get(str) > 1)
                ans.add(str);
        return ans;
    }
}
