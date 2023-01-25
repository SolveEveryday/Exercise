package BOJ_13549;

import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int location;
        int time;

        public Node(int location, int time) {
            this.location = location;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K  = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(N, 0));

        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.location] = true;

            if (node.location == K) {
                answer = Math.min(answer, node.time);
            }

            if (node.location * 2 < visited.length && !visited[node.location * 2]) {
                queue.add(new Node(node.location * 2, node.time));
            }

            if (node.location + 1 < visited.length && !visited[node.location + 1]) {
                queue.add(new Node(node.location + 1, node.time + 1));
            }

            if (node.location - 1 >= 0 && !visited[node.location - 1]) {
                queue.add(new Node(node.location - 1, node.time + 1));
            }
        }

        System.out.println(answer);
    }
}
