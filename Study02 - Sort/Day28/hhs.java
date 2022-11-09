package BOJ_18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] X = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] copyX = Arrays.copyOf(X, X.length);
        quickSort(copyX, 0, copyX.length - 1);
        Map<Integer, Integer> map = new HashMap<>();

        int index = 0;
        for (int key : copyX) {
            if (!map.containsKey(key)) {
                map.put(key, index++);
            }
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(X).forEach(x -> sb.append(map.get(x)).append(" "));
        System.out.println(sb);
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


