package BOJ_2841;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (!map.containsKey(a)) {
                map.put(a, new ArrayDeque<>());
            }

            Deque<Integer> deque = map.get(a);

            while (!deque.isEmpty() && deque.peekLast() > b) {
                deque.removeLast();
                answer++;
            }

            if ((!deque.isEmpty() && deque.peekLast() != b) || deque.isEmpty()) {
                deque.add(b);
                answer++;
            }
        }

        System.out.println(answer);
    }
}
