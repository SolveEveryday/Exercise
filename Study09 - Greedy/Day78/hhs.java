package BOJ_2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int temp = 0;
        int answer = Integer.MAX_VALUE;

        if (N % 5 == 0) {
            answer = N / 5;
        } else {
            while (temp < N) {
                if ((N - temp) % 3 == 0) {
                    answer = Math.min(answer, (N - temp) / 3 + temp / 5);
                }

                temp += 5;
            }
        }

        System.out.println((answer != Integer.MAX_VALUE) ? answer : -1);
    }
}
