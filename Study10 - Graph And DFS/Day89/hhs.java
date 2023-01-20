package BOJ_13023;

import java.util.*;
import java.io.*;

public class Main {

    static int N, M, answer = 0;
    static int count;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            count = 0;
            dfs(i, count);
            if (answer == 1) {
                break;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int node, int count) {
        visited[node] = true;
        if (count >= 4) {
            answer = 1;
            return;
        }

        for (int nextNode : graph.get(node)) {
            if (!visited[nextNode]) {
                dfs(nextNode, count + 1);
            }
        }
        visited[node] = false;
    }
}
