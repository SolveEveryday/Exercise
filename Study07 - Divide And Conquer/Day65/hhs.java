package BOJ_11582;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] src, tmp;
    static int N, K;

    public static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);

            if (end - start > N / K)
                return;

            int p = start;
            int q = mid + 1;
            int idx = p;

            while (p <= mid || q <= end) {
                if (q > end || (p <= mid && src[p] < src[q])) {
                    tmp[idx++] = src[p++];
                } else {
                    tmp[idx++] = src[q++];
                }
            }

            if (end + 1 - start >= 0)
                System.arraycopy(tmp, start, src, start, end + 1 - start);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        src = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        tmp = new int[src.length];
        K = Integer.parseInt(br.readLine());

        mergeSort(0, N - 1);

        StringBuilder sb = new StringBuilder();

        for (int x : src) {
            sb.append(x).append(' ');
        }

        System.out.println(sb);
    }
}
