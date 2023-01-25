package BOJ_16234;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] populations, matrix, moveYX = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static boolean flag;
    static int N, L, R;

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int answer = 0;

        populations = new int[N][N];
        matrix = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                populations[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (answer < 2000) {
            flag = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;

                    int currentP = populations[i][j];

                    for (int k = 0; k < 4; k++) {
                        int moveY = i + moveYX[k][0];
                        int moveX = j + moveYX[k][1];

                        if (moveY >= 0 && moveY < N && moveX >= 0 && moveX < N) {
                            int moveP = populations[moveY][moveX];

                            int compare = Math.abs(moveP - currentP);
                            if (compare >= L && compare <= R && !visited[moveY][moveX]) {
                                bfs(new Node(i, j));
                            }
                        }
                    }
                }
            }

            if (!flag) break;
            clearVisited();
            answer++;
        }

        System.out.println(answer);
    }

    public static void bfs(Node node) {
        if (visited[node.y][node.x]) return;

        List<Node> list = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited[node.y][node.x] = true;

        int sum = 0;
        while (!queue.isEmpty()) {
            Node cNode = queue.poll();
            list.add(cNode);

            sum += populations[cNode.y][cNode.x];
            for (int k = 0; k < 4; k++) {
                int moveY = cNode.y + moveYX[k][0];
                int moveX = cNode.x + moveYX[k][1];

                if (moveY >= 0 && moveY < N && moveX >= 0 && moveX < N) {
                    int moveP = populations[moveY][moveX];
                    int currentP = populations[cNode.y][cNode.x];

                    int compare = Math.abs(moveP - currentP);
                    if (compare >= L && compare <= R && !visited[moveY][moveX]) {
                        queue.add(new Node(moveY, moveX));
                        visited[moveY][moveX] = true;
                        flag = true;
                    }
                }
            }
        }

        int size = list.size();
        int movePopulation = sum / size;

        for (Node n : list) {
            populations[n.y][n.x] = movePopulation;
        }
    }

    public static void clearVisited() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
    }
}
