package BOJ_14465;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int B = Integer.parseInt(input[2]);

        int[] numbers = new int[N + 1];
        Arrays.fill(numbers, 1);

        numbers[0] = 0;
        for (int i = 0; i < B; i++) {
            int index = Integer.parseInt(br.readLine());

            numbers[index] = 0;
        }

        for (int i = 1; i <= N; i++) {
                numbers[i] += numbers[i - 1];
        }

        int answer = 0;

        for (int i = 1; i <= N - K + 1; i++) {
            for (int j = i; j <= i + K - 1; j++) {
                answer = Math.max(answer, numbers[j] - numbers[i - 1]);
            }
        }

        System.out.println(K - answer);
    }
}
