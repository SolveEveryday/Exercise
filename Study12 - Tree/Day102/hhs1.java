package BOJ_1240;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[][] matrix;

    public static void dfs(int node, int target, int sum) {
        visited[node] = true;
        if (node == target) {
            System.out.println(sum);
        }

        for (int nextNode = 0; nextNode < matrix[node].length; nextNode++) {
            
            if (!visited[nextNode] && matrix[node][nextNode] > 0) {
                dfs(nextNode, target, sum + matrix[node][nextNode]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            matrix[a][b] = v;
            matrix[b][a] = v;
        }

        for (int i = 0; i < M; i++) {
            Arrays.fill(visited, false);
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            dfs(start, target, 0);
        }
    }
}