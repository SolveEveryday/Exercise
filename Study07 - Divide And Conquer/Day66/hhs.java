package BOJ_12829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] matrix;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (N >= 2) {
            reduceMatrix(0, 0, N);
            N /= 2;
        }

        System.out.println(matrix[0][0]);
    }

    static void reduceMatrix(int y, int x, int size) {
        if (size == 2) {
            matrix[y / 2][x / 2] = compareFourValue(y, x);
            return;
        }

        int newSize = size / 2;
        reduceMatrix(y, x, newSize);
        reduceMatrix(y, x + newSize, newSize);
        reduceMatrix(y + newSize, x, newSize);
        reduceMatrix(y + newSize, x + newSize, newSize);
    }

    static int compareFourValue(int y, int x) {
        pq.add(matrix[y][x]);
        pq.add(matrix[y][x + 1]);
        pq.add(matrix[y + 1][x]);
        pq.add(matrix[y + 1][x + 1]);

        pq.poll();
        int result = pq.poll();

        pq.clear();
        return result;
    }
}
