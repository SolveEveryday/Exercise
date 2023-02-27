import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] positions = {{1, 0}, {-1, 0}, {0 ,1}, {0, -1}};

    static class Node implements Comparable<Node> {
        int y, x, w;

        public Node(int y, int x, int w) {
            this.y = y;
            this.x = x;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] miro = new int[N + 1][M + 1];
        int[][] visited = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= M; j++) {
                miro[i][j] = input.charAt(j - 1) - '0';
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 1, 0));
        visited[1][1] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.y == N && node.x == M) {
                System.out.println(node.w);
                break;
            }

            if (visited[node.y][node.x] < node.w) continue;

            for (int i = 0; i < 4; i++) {
                int moveY = node.y + positions[i][0];
                int moveX = node.x + positions[i][1];

                if (moveY > 0 && moveY <= N && moveX > 0 && moveX <= M) {
                    int nextW = visited[node.y][node.x] + miro[moveY][moveX];

                    if (visited[moveY][moveX] > nextW) {
                        visited[moveY][moveX] = nextW;
                        pq.add(new Node(moveY, moveX, nextW));
                    }
                }
            }
        }
    }
}