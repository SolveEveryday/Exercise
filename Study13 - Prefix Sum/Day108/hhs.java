package BOJ_16139;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] alphabets = new int[26][200001];

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            alphabets[c - 'a'][i] = 1;
        }

        for (int i = 0; i < 26; i++) {
            int[] alphabet = alphabets[i];
            for (int j = 1; j < 200001; j++) {
                alphabet[j] += alphabet[j - 1];
            }
        }

        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String[] input = br.readLine().split(" ");

            char target = input[0].charAt(0);
            int startValue;
            try {
                startValue = alphabets[target - 'a'][Integer.parseInt(input[1]) - 1];
            } catch (Exception e) {
                startValue = 0;
            }
            int endValue = alphabets[target - 'a'][Integer.parseInt(input[2])];
            sb.append(endValue - startValue).append('\n');
        }

        System.out.println(sb);
    }
}
