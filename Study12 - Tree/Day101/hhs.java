package BOJ_15681;

import java.io.*;
import java.util.*;

public class Main {
    static int N, R, Q;
    static List<List<Integer>> lists = new ArrayList<>();
    static boolean[] visited;
    static int[] count;

    public static int dfs(int node) {
        count[node] = 1;
        visited[node] = true;

        for (int nextNode : lists.get(node)) {
            if (visited[nextNode]) continue;
            count[node] += dfs(nextNode);
        }

        return count[node];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        count = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lists.get(a).add(b);
            lists.get(b).add(a);
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            sb.append(count[Integer.parseInt(br.readLine())]).append('\n');
        }

        System.out.println(sb);
    }
}
