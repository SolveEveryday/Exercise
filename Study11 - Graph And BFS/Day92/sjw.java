import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] miro;
    static boolean[][] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        miro = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();

            for (int j = 0; j < m; j++) {
                miro[i][j] = line.charAt(j) - 48;
            }
        }

        bfs(0, 0);
        System.out.println(miro[n-1][m-1]);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { i, j });
        visited[i][j] = true;

        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x < 0 || x >= n || y < 0 || y >= m) continue;

                if (1 == miro[x][y] && !visited[x][y]) {
                    visited[x][y] = true;
                    miro[x][y] = miro[now[0]][now[1]] + 1;
                    q.offer(new int[] { x, y });
                }
            }
        }
    }
}
