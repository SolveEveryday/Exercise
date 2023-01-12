import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertex = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[vertex + 1];
        LinkedList<Integer>[] adjList = new LinkedList[vertex + 1];

        for (int i = 0; i <= vertex; i++) {
            adjList[i] = new LinkedList<>();
        }

        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        dfs(1, adjList, visited);

        System.out.println(answer);
    }

    public static void dfs(int r, LinkedList<Integer>[] adjList, boolean[] visited) {
        visited[r] = true;

        for (int node : adjList[r]) {
            if (!visited[node]) {
                answer++;
                dfs(node, adjList, visited);
            }
        }
    }
}
