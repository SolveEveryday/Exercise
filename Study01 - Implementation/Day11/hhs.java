package BOJ_1592;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, M, L;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int nextIndex = 1;
        int[] people = new int[N + 1];
        people[1]++;
        int totalBall = 0;

        while (people[nextIndex] != M) {

            if (people[nextIndex] % 2 == 1) {
                nextIndex += L;
            } else {
                nextIndex -= L;
            }

            if (nextIndex <= 0) {
                nextIndex = N + nextIndex;
            } else if (nextIndex > N) {
                nextIndex %= N;
            }

            people[nextIndex]++;
            totalBall++;
        }

        System.out.println(totalBall);
    }
}
