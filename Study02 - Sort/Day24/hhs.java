package BOJ_10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        quickSort(numbers, 0, numbers.length - 1);

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            int temp = Integer.parseInt(st.nextToken());

            if (Arrays.binarySearch(numbers, temp) >= 0) {
                sb.append(1).append(' ');
            } else {
                sb.append(0).append(' ');
            }
        }

        System.out.println(sb);
    }

    private static void quickSort(int[] arr, int start, int end) {
        int part = partition(arr, start, end);
        if (start < part - 1) quickSort(arr, start, part - 1);
        if (end > part) quickSort(arr, part, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }
}
