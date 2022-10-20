package BOJ_1377;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Point[] values = new Point[N];
        Point[] temp = new Point[N];

        for (int i = 0; i < N; i++) {
            values[i] = new Point(Integer.parseInt(br.readLine()), i);
        }

        mergeSort(0, values.length - 1, values, temp);

        int answer = 0;

        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, values[i].idx - i);
        }

        System.out.println(answer + 1);
    }

    public static void mergeSort(int start, int end, Point[] targetArray, Point[] temp) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid, targetArray, temp);
            mergeSort(mid + 1, end, targetArray, temp);

            int p = start;
            int q = mid + 1;
            int idx = p;

            while (p <= mid || q <= end) {
                if (q > end || (p <= mid && targetArray[p].compareTo(targetArray[q]) <= 0)) {
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

class Point implements Comparable<Point> {
    int value;
    int idx;

    public Point(int value, int idx) {
        this.value = value;
        this.idx = idx;
    }

    @Override
    public int compareTo(Point o) {
        return value - o.value;
    }
}