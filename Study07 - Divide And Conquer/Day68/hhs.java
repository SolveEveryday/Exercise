package BOJ_4779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);

            int size = (int) Math.pow(3, N);
            answer = new char[size];
            Arrays.fill(answer, '-');
            R(0, size);

            System.out.println(answer);
        }
    }

    static void R(int s, int size) {
        if (size == 1) {
            return;
        }

        int newSize = size / 3;
        for (int i = s + newSize; i < s + newSize * 2; i++) {
            answer[i] = ' ';
        }

        R(s, newSize);
        R(s + newSize * 2, newSize);
    }
}
