import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, R, Q;
	static List<Integer>[] adj;
	static int[] size;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N+1];
		size = new int[N + 1];

		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());

			adj[U].add(V);
			adj[V].add(U);
		}

		countSubtreeNodes(R, -1);
		while (Q-- > 0) {
			int u = Integer.parseInt(br.readLine());
			System.out.println(size[u]);
		}
	}
	static void countSubtreeNodes(int v, int p) {
		size[v] = 1; // 자신도 자신을 루트로 하는 서브트리에 포함되므로 0이 아닌 1에서 시작한다.
		for (int u : adj[v]) {
			if (u == p) continue;
			countSubtreeNodes(u, v);
			size[v] += size[u];
		}
	}
}
