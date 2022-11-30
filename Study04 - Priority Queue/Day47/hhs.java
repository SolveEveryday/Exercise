package BOJ_11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int a = Math.abs(o1);
            int b = Math.abs(o2);

            if (a == b)
                return (o1 > o2) ? 1 : -1;
            return a - b;
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (temp == 0) {
                if (priorityQueue.isEmpty()) {
                    sb.append('0').append('\n');
                } else {
                    sb.append(priorityQueue.poll()).append('\n');
                }
            } else {
                priorityQueue.add(temp);
            }
        }

        System.out.println(sb);
    }
}
