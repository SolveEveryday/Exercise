import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static List<Edge>[] adj;
	static int[] dist;
	static boolean[] visit;

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
		M = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		dist = new int[M];

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

		for (int i = 0; i < M; i++) {
			visit = new boolean[N + 1];
			ans = 0;
			st = new StringTokenizer(br.readLine());

			int cur = Integer.parseInt(st.nextToken());
			int goal = Integer.parseInt(st.nextToken());

			dfs(cur, goal, 0);
			dist[i] = ans;
		}

		for (int i : dist) {
			System.out.println(i);
		}
	}
	static void dfs(int cur, int goal, int cost) {
		if(cur == goal){
			ans = cost;
		}

		visit[cur] = true;

		for (Edge edge : adj[cur]) {
			if (visit[edge.n]) continue;
			visit[edge.n] = true;
			dfs(edge.n, goal, cost + edge.cost);
		}
	}
}
