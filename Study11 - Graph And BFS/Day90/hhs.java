package BOJ_24444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int N, M, R;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[node] != 0) continue;
            visited[node] = count++;

            for (int nextNode : graph.get(node)) {
                if (visited[nextNode] == 0) {
                    queue.add(nextNode);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append('\n');
        }

        System.out.println(sb);
    }
}
