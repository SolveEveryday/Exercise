import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    public static int bfs() {
        if(n == k) return 0;

        boolean[] visited = new boolean[100001];
        LinkedList<Point> q = new LinkedList<>();

        q.add(new Point(n, 0)); // 위치, 시간
        visited[n] = true;

        while (!q.isEmpty()) {
            Point point = q.poll();
            visited[point.pos] = true;

            if(point.pos == k) return point.time;

            if (point.pos * 2 <= 100000 && !visited[point.pos * 2]) {
                q.add(new Point(point.pos * 2, point.time));
            }

            if (point.pos -1 >= 0  && !visited[point.pos -1]) {
                q.add(new Point(point.pos - 1, point.time + 1));
            }
            if (point.pos + 1 <=100000 && !visited[point.pos + 1]) {
                q.add(new Point(point.pos + 1, point.time + 1));
            }

        }
        return -1;
    }

    static class Point{
        int pos;
        int time;

        public Point(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }
}