import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] field;
    static int N, L, R;
    static boolean[][] visited;
    static boolean moveStatus;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        field = new int[N][N];

        // 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 인구이동시작
        int days = 0;

        while (true) {
            // 이동했는지 플래그, 방문 초기화
            moveStatus = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    //
                    if (!visited[i][j] && bfs(i, j) > 1) {
                        moveStatus = true;
                    }
                }
            }
            // 인구이동 했는 지 체크
            if (!moveStatus) break;

            // 했으면 날짜 증가
            days++;
        }
        System.out.println(days);
    }

    private static int bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> unionInfoList = new ArrayList<>();

        q.offer(new int[]{i, j});
        unionInfoList.add(new int[]{i, j});

        visited[i][j] = true;
        int sum = field[i][j];

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (isValidRange(now, nx, ny)) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    unionInfoList.add(new int[]{nx, ny});
                    sum += field[nx][ny];
                }
            }
        }

        if (unionInfoList.size() != 1) {
            // 인구 분배
            int avg = sum / unionInfoList.size();

            //인구 세팅
            for (int[] ints : unionInfoList) {
                field[ints[0]][ints[1]] = avg;
            }
        }
        return unionInfoList.size();
    }

    private static boolean isValidRange(int[] point, int nx, int ny) {
        return L <= Math.abs(field[point[0]][point[1]] - field[nx][ny])
                && Math.abs(field[point[0]][point[1]] - field[nx][ny]) <= R;
    }
}
