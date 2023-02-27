package BOJ_1504;

import java.util.*;
import java.io.*;

public class Main {

    static int N, E;
    static List<List<Node>> graph = new ArrayList<>();
    public static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int n, w;

        public Node(int n, int w) {
            this.n = n;
            this.w = w;
        }

        public int compareTo(Node o) {
            return w - o.w;
        }
    }

    public static long dijkstra(int s, int e) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF);

        distance[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (distance[node.n] < node.w) continue;

            for (Node nextNode : graph.get(node.n)) {
                int nextW = distance[node.n] + nextNode.w;

                if (distance[nextNode.n] > nextW) {
                    distance[nextNode.n] = nextW;
                    pq.add(new Node(nextNode.n, nextW));
                }
            }
        }

        return distance[e];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i ++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long answer = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        answer = Math.min(answer, dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N));

        System.out.println((answer >= INF) ? -1 : answer);
    }
}
