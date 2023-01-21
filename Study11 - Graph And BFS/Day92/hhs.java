package BOJ_2178;

import java.util.*;
import java.io.*;

public class Main2 {

    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int N, M;
    static int[][] matrix;
    static boolean[][] visited;
    static int[][] moveYX = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = input.charAt(j) - '0';
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        visited[0][0] = true;

        int answer = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.y + 1 == N && node.x + 1 == M) {
                answer = node.count;
            }

            for (int i = 0; i < 4; i++) {
                int moveY = node.y + moveYX[i][0];
                int moveX = node.x + moveYX[i][1];

                if (moveX >= 0 && moveX < M && moveY >= 0 && moveY < N) {
                    if (matrix[moveY][moveX] == 1 && !visited[moveY][moveX]) {
                        visited[moveY][moveX] = true;
                        queue.add(new Node(moveX, moveY, node.count + 1));
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
