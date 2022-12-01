package BOJ_1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            priorityQueue.add(Long.parseLong(br.readLine()));
        }

        long answer = 0;
        while (priorityQueue.size() > 1) {
            long a = priorityQueue.poll();
            long b = priorityQueue.poll();

            answer += a + b;
            priorityQueue.add(a + b);
        }

        System.out.println(answer);
    }
}
