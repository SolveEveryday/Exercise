package BOJ_1916;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance;
    public static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int n;
        int w;

        public Node(int n, int w) {
            this.n = n;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }

    public static void dijkstra(int start){
        distance = new int[N + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (distance[node.n] < node.w) continue;

            for (Node nextNode : graph.get(node.n)) {
                int nextWeight = distance[node.n] + nextNode.w;
                if (nextWeight < distance[nextNode.n]) {
                    distance[nextNode.n] = nextWeight;
                    pq.add(new Node(nextNode.n, nextWeight));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        dijkstra(a);

        System.out.println(distance[b]);
    }
}
