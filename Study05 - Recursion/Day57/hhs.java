package pro_84512;

import java.util.*;

public class Solution {
    static String[] letters = new String[] {"", "A", "E", "I", "O", "U"};
    static Set<String> words = new TreeSet<>();

    public static void makeWords(int depth, String word) {
        if (depth == 5) {
            words.add(word);
            return;
        }

        for (String letter : letters) {
            makeWords(depth + 1, word + letter);
        }
    }

    public int solution(String word) {
        makeWords(0, "");
        return new ArrayList<>(words).indexOf(word);
    }

    public static void main(String[] args) {
        makeWords(0, "");
        System.out.println(new Solution().solution("A"));
    }
}
