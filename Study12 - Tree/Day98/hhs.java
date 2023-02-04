package BOJ_18126;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static long answer = 0;
    static int N;
    static List<List<Node>> lists = new ArrayList<>();
    static boolean[] visited = new boolean[5001];

    static class Node {
        int target;
        long weight;

        public Node(int target, long weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            long C = Long.parseLong(st.nextToken());

            lists.get(A).add(new Node(B, C));
            lists.get(B).add(new Node(A, C));
        }

        visited[1] = true;
        dfs(1, 0);

        System.out.println(answer);
    }

    public static void dfs(int index, long sum) {
        answer = Math.max(answer, sum);

        for (Node node : lists.get(index)) {
            if (visited[node.target]) continue;

            visited[node.target] = true;
            dfs(node.target, sum + node.weight);
            visited[node.target] = false;
        }
    }
}
