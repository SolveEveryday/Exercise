package BOJ_1967;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<List<Node>> lists = new ArrayList<>();
    static boolean[] visited;
    static int answer = 0;

    static class Node {
        int n, v;

        public Node(int n, int v) {
            this.n = n;
            this.v = v;
        }
    }

    public static void dfs(int n, int sum) {
        visited[n] = true;

        for (Node nextNode : lists.get(n)) {
            if (visited[nextNode.n]) continue;
            dfs(nextNode.n, sum + nextNode.v);
        }

        visited[n] = false;
        answer = Math.max(answer, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            lists.get(a).add(new Node(b, v));
            lists.get(b).add(new Node(a, v));
        }

        for (int i = 1; i <= N; i++) {
            dfs(i, 0);
        }

        System.out.println(answer);
    }
}
