package BOJ_1238;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M, X;
    static List<List<Edge>> graph = new ArrayList<>();
    static List<List<Edge>> reverseGraph = new ArrayList<>();
    public static final int INF = Integer.MAX_VALUE;

    static class Edge implements Comparable<Edge> {
        int n, v;

        public Edge(int n, int v) {
            this.n = n;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            return v - o.v;
        }
    }

    public static void dijkstra(int n, int[] distance, List<List<Edge>> graph) {
        Arrays.fill(distance, INF);
        distance[n] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(n, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (distance[edge.n] < edge.v) continue;

            for (Edge nextEdge : graph.get(edge.n)) {
                int sumV = distance[edge.n] + nextEdge.v;

                if (distance[nextEdge.n] > sumV) {
                    distance[nextEdge.n] = sumV;
                    pq.add(new Edge(nextEdge.n, sumV));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        X = Integer.parseInt(input[2]);

        int[] distanceTo = new int[N + 1];
        int[] distanceFrom = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            graph.get(a).add(new Edge(b, c));
            reverseGraph.get(b).add(new Edge(a, c));
        }

        dijkstra(X, distanceTo, graph);
        dijkstra(X, distanceFrom, reverseGraph);

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, distanceTo[i] + distanceFrom[i]);
        }

        System.out.println(answer);
    }
}
