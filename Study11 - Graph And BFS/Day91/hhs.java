package BOJ_16953;

import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        long value;
        int depth;

        public Node(long value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        long start = Long.parseLong(input[0]);
        long end = Long.parseLong(input[1]);

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start, 0));

        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.value == end) {
                answer = Math.min(answer, node.depth);
            } else if (node.value > end) {
                continue;
            }

            queue.add(new Node(node.value * 2, node.depth + 1));
            queue.add(new Node(node.value * 10 + 1, node.depth + 1));
        }

        System.out.println((answer != Integer.MAX_VALUE) ? answer + 1 : -1);
    }
}
