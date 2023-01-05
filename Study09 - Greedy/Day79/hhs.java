package BOJ_1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alphabets = new int[26];
        String input = br.readLine();

        for (char ch : input.toCharArray()) {
            alphabets[ch - 'A']++;
        }

        StringBuilder sb = new StringBuilder();
        String middle = "";

        for (int i = 0; i < 26; i++) {
            sb.append(String.valueOf((char) (i + 'A')).repeat(alphabets[i] / 2));
            if (alphabets[i] % 2 == 1)
                middle = String.valueOf((char) (i + 'A'));
        }

        String result = sb.toString();
        result += middle + sb.reverse();

        System.out.println((result.length() == input.length()) ? result : "I'm Sorry Hansoo");
    }

}
