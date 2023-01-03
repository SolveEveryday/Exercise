package BOJ_1417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < (N - 1); i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;

        while (!pq.isEmpty()) {
            if (pq.peek() < target) {
                break;
            }

            pq.add(pq.poll() - 1);
            target++;
            answer++;
        }

        System.out.println(answer);
    }
}
