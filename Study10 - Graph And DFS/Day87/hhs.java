package BOJ_1012;

import java.util.*;
import java.io.*;

public class Main {
    static int[][] matrix, visited;
    static int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int count, N, M;

    public static void dfs(int y, int x) {
        visited[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int moveY = y + direction[i][0];
            int moveX = x + direction[i][1];

            if (isValidPoint(moveY, moveX)) {
                if (matrix[moveY][moveX] == 1 && visited[moveY][moveX] != 1) {
                    dfs(moveY, moveX);
                }
            }
        }
    }

    public static boolean isValidPoint(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            matrix = new int[N][M];
            visited = new int[N][M];
            count = 0;

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                matrix[y][x] = 1;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (matrix[j][k] == 1 && visited[j][k] != 1) {
                        dfs(j, k);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
