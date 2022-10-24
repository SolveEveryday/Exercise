package BOJ_2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N * N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                array[N * i + j] = Integer.parseInt(st.nextToken());
            }
        }

        mergeSort(0, N * N - 1, array, new int[N * N]);
        System.out.println(array[N - 1]);
    }

    public static void mergeSort(int start, int end, int[] targetArray, int[] temp) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid, targetArray, temp);
            mergeSort(mid + 1, end, targetArray, temp);

            int p = start;
            int q = mid + 1;
            int idx = p;

            while (p <= mid || q <= end) {
                if (q > end || (p <= mid && targetArray[p] > targetArray[q])) {
                    temp[idx++] = targetArray[p++];
                } else {
                    temp[idx++] = targetArray[q++];
                }
            }

            for (int i = start; i <= end; i++) {
                targetArray[i] = temp[i];
            }
        }
    }
}
