import java.util.*;
import java.io.*;

public class Main {
	static class Edge {
		int to, cost;

		Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	static int[] dist;
	static List<Edge>[] adjList;
	static int start, end;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		adjList = new ArrayList[n + 1];
		dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adjList[u].add(new Edge(v, c));
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		System.out.println(dijkstra());
	}

	private static int dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(e -> e.cost));

		dist[start] = 0;
		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (dist[cur.to] < cur.cost)
				continue;

			// 연결된 버스 확인
			for (Edge e : adjList[cur.to]) {
				if (dist[cur.to] + e.cost < dist[e.to]) {
					dist[e.to] = dist[cur.to] + e.cost;
					pq.offer(new Edge(e.to, e.cost));
				}
			}
		}
		return dist[end];
	}
}
