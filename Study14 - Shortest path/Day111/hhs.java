package BOJ_1753;

import java.util.*;
import java.io.*;

public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance;
    static int V, E;
    public static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int n;
        int sumWeight;

        public Node(int n, int sumWeight) {
            this.n = n;
            this.sumWeight = sumWeight;
        }

        public int compareTo(Node o) {
            return sumWeight - o.sumWeight;
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node temp = pq.poll();

            if (distance[temp.n] < temp.sumWeight) continue;

            for (Node nextNode : graph.get(temp.n)) {
                int nextSumWeight = distance[temp.n] + nextNode.sumWeight;
                if (nextSumWeight < distance[nextNode.n]) {
                    distance[nextNode.n] = nextSumWeight;
                    pq.add(new Node(nextNode.n, nextSumWeight));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        distance = new int[V + 1];
        Arrays.fill(distance, INF);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            sb.append((distance[i] != INF) ? distance[i] : "INF").append('\n');
        }

        System.out.println(sb);
    }
}
