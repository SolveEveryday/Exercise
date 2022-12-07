package BOJ_1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long A, B, C;

    public static long pow(long base, long exponent) {
        if (exponent == 1) {
            return base % C;
        }

        long temp = pow(base, exponent / 2);

        if (exponent % 2 == 1) {
            return (temp * temp % C) * base % C;
        }

        return temp * temp % C;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }
}
