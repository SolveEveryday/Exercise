package BOJ_11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value == 0) {
                int temp = 0;

                if (!priorityQueue.isEmpty()) {
                    temp = priorityQueue.poll();
                }

                sb.append(temp).append('\n');
                continue;
            }

            priorityQueue.add(value);
        }

        System.out.println(sb);
    }
}
