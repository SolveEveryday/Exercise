package BOJ_15903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>(Arrays.stream(br.readLine().split(" "))
                .map(Long::parseLong).collect(Collectors.toList()));

        for (int i = 0; i < M; i++) {
            long x = pq.poll();
            long y = pq.poll();

            pq.add(x + y);
            pq.add(x + y);
        }

        long answer = 0;

        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        System.out.println(answer);
    }
}
