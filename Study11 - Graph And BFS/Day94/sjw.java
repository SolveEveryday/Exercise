import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            System.out.println(n - k);
        } else {
            System.out.println(bfs());
        }
    }

    public static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[1000001];
        int[] time = new int[1000001];
        Arrays.fill(time, Integer.MAX_VALUE);

        q.add(n);
        visited[n] = true;
        time[n] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr == k) {
                return time[curr];
            }

            int left = curr - 1;
            if (left >= 0 && !visited[left]) {
                q.add(left);
                visited[left] = true;
                time[left] = time[curr] + 1;
            }

            int right = curr + 1;
            if (right <= 1000000 && !visited[right]) {
                q.add(right);
                visited[right] = true;
                time[right] = time[curr] + 1;
            }

            int teleport = curr * 2;
            if (teleport <= 1000000 && !visited[teleport]) {
                q.add(teleport);
                visited[teleport] = true;
                time[teleport] = time[curr];
            }
        }

        return -1;
    }
}
