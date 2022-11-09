package BOJ_1491;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        quickSort(A, 0, A.length - 1);

        boolean isMinus = false;
        int answer = Integer.MAX_VALUE;

        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            int sum = A[left] + A[right];

            if (Math.abs(sum) < answer) {
                isMinus = (sum < 0);
                answer = Math.abs(sum);
            }

            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                break;
            }
        }

        System.out.println((isMinus) ? (-1 * answer) : answer);
    }

    private static void quickSort(int[] arr, int start, int end) {
        int part = partition(arr, start, end);
        if (start < part - 1) {
            quickSort(arr, start, part - 1);
        }
        if (end > part) {
            quickSort(arr, part, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
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
