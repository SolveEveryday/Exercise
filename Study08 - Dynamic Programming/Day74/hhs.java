package BOJ_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] RGB = new int[N][3];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            RGB[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dp[0][0] = RGB[0][0];
        dp[0][1] = RGB[0][1];
        dp[0][2] = RGB[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = RGB[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = RGB[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = RGB[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        System.out.println(Arrays.stream(dp[N - 1]).min().getAsInt());
    }
}
