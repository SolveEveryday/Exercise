package BOJ_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] values =
                Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[N];


        Arrays.fill(dp, 1);
        int answer = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (values[i] > values[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);
    }
}
