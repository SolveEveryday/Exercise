package BOJ_1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N, R, C, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        solve((int) Math.pow(2, N), R, C);
    }

    public static void solve(int size, int r, int c) {
        if (size == 1) {
            System.out.println(count);
            return;
        }

        int n = size / 2;
        if (r < n && c < n) { // 1사분면
            count += n * n * 0;
            solve(n, r, c);
        } else if (r < n && c < n + n) { // 2사분면
            count += n * n * 1;
            solve(n, r, c - n);
        } else if (r < n + n && c < n) { // 3사분면
            count += n * n * 2;
            solve(n, r - n, c);
        } else if (r < n + n && c < n + n) { // 4사분면
            count += n * n * 3;
            solve(n, r - n, c - n);
        }
    }
}
