import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long ans;
	static ArrayList<Edge>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			graph[a].add(new Edge(b, c));
			graph[b].add(new Edge(a, c));
		}
		visited = new boolean[n+1];
		ans = Integer.MIN_VALUE;
		dfs(1, 0);
		System.out.println(ans);
	}

	private static void dfs(int node, long dist) {
		visited[node] = true;
		ans = Math.max(ans, dist);
		for (Edge edge : graph[node]) {
			if (!visited[edge.to]) {
				dfs(edge.to, dist + edge.cost);
			}
		}
	}

	static class Edge {
		int to;
		long cost;

		public Edge(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}
	}
}