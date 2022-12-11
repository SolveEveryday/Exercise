package BOJ_1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] matrix;
    static StringBuilder sb = new StringBuilder();

    public static boolean isAllFill(int y, int x, int size) {
        int value = matrix[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (matrix[i][j] != value) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void makeQuadTree(int y, int x, int size) {
        if (isAllFill(y, x, size)) {
            sb.append(matrix[y][x]);
            return;
        }

        int newSize = size / 2;
        sb.append("(");
        makeQuadTree(y, x, newSize);
        makeQuadTree(y, x + newSize, newSize);
        makeQuadTree(y + newSize, x, newSize);
        makeQuadTree(y + newSize, x + newSize, newSize);
        sb.append(")");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < input.length(); j++) {
                matrix[i][j] = input.charAt(j) - '0';
            }
        }

        makeQuadTree(0, 0, N);
        System.out.println(sb);
    }
}
