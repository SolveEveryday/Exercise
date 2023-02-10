import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Edge>[] adj;
	static boolean[] visit;
	static int result = 0;

	static class Edge {
		int n, cost;

		public Edge(int n, int cost) {
			this.n = n;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adj[x].add(new Edge(y, c));
			adj[y].add(new Edge(x, c));
		}

		for (int i = 1; i <= N; i++) {
			visit = new boolean[N + 1];
			visit[i] = true;
			dfs(i, 0);
		}
		System.out.println(result);
	}

	static void dfs(int node, int cost) {
		result = Math.max(cost, result);

		for (Edge edge : adj[node]) {
			int temp = edge.n;
			if (visit[temp]) continue;

			visit[temp] = true;
			dfs(temp, edge.cost + cost);
		}
	}
}
