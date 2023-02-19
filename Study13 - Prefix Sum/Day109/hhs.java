import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            arr[i] = i + arr[i - 1];
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int cw = arr[j] - arr[i];
                int ccw = arr[N] - (cw);

                int minValue = Math.min(cw, ccw);
                if (minValue == 0) continue;

                answer = Math.max(answer, minValue);
            }
        }

        System.out.println(answer);
    }
}