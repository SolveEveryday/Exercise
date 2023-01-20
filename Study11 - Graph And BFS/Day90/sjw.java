import java.util.*;

public class Main {
    static int[] visited;
    static TreeSet<Integer>[] edges;
    static int cnt = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();

        edges = new TreeSet[n];
        visited = new int[n];

        for (int i = 0; i < n; i++) {
            edges[i] = new TreeSet<>();
        }

        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            edges[v1 - 1].add(v2 - 1);
            edges[v2 - 1].add(v1 - 1);
        }

        bfs(r - 1);

        for (int i = 0; i < n; i++) {
            System.out.println(visited[i]);
        }
    }

    static void bfs(int r) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(r);
        visited[r] = cnt++;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int nextNode : edges[x]) {
                if (visited[nextNode] == 0) {
                    queue.offer(nextNode);
                    visited[nextNode] = cnt++;
                }
            }
        }
    }
}