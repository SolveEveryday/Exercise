package BOJ_11501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] stockPrices = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                stockPrices[j] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            int bestStock = stockPrices[N - 1];

            for (int j = N - 2; j >= 0; j--) {
                int value = stockPrices[j];
                if (bestStock > value) {
                    answer += bestStock - value;
                } else {
                    bestStock = value;
                }
            }

            System.out.println(answer);
        }
    }
}
