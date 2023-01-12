package BOJ_1339;

import java.io.*;
import java.util.*;

public class Main2 {

    static List<String> words = new ArrayList<>();
    static Set<Character> set = new HashSet<>();
    static int[] priority = new int[10];
    static int[] alphabets = new int[26];
    static boolean[] check = new boolean[10];
    static long answer = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words.add(word);

            word.chars().forEach(x -> set.add((char) x));
        }

        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int depth) {
        if (depth == set.size()) {
            answer = Math.max(answer, cal());
            return;
        }

        for (int i = 9; i >= 10 - set.size(); i--) {
            if (!check[i]) {
                check[i] = true;
                priority[depth] = i;
                dfs(depth + 1);
                priority[depth] = 0;
                check[i] = false;
            }
        }
    }

    static long cal() {
        int temp = 0;
        for (char c : set) {
            alphabets[c - 'A'] = priority[temp++];
        }

        int result = 0;
        for (String word : words) {
            int digit = word.length() - 1;
            int sum = 0;
            for (char c : word.toCharArray()) {
                sum *= 10;
                sum += alphabets[c - 'A'];
            }
            result += sum;
        }

        return result;
    }
}
