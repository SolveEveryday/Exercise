package BOJ_1240;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] dist;
    static List<List<Node>> nodes = new ArrayList<>();

    static class Node implements Comparable<Node> {
        int target, v;

        public Node(int target, int v) {
            this.target = target;
            this.v = v;
        }

        public int compareTo(Node o) {
            return v - o.v;
        }
    }

    public static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (visited[current.target]) continue;
            visited[current.target] = true;

            for (Node nextNode : nodes.get(current.target)) {
                if (dist[nextNode.target] > dist[current.target] + nextNode.v) {
                    dist[nextNode.target] = dist[current.target] + nextNode.v;
                    pq.add(new Node(nextNode.target, dist[nextNode.target]));
                }
            }
        }
        System.out.println(dist[end]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        dist = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodes.get(a).add(new Node(b, v));
            nodes.get(b).add(new Node(a, v));
        }

        for (int i = 0; i < M; i++) {
            Arrays.fill(visited, false);
            Arrays.fill(dist, Integer.MAX_VALUE);
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            dijkstra(start, end);
        }
    }
}
