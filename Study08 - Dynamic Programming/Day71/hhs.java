package BOJ_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] values = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = values[1];

        if (N >= 2)
            dp[2] = values[1] + values[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + values[i - 1]) + values[i];
        }

        System.out.println(dp[N]);
    }
}
