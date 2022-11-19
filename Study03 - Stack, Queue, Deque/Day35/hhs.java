package BOJ_20301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque =
                new ArrayDeque<>(IntStream.range(1, N + 1).boxed().collect(Collectors.toList()));

        boolean isClockwise = true;
        List<Integer> answer = new ArrayList<>();
        int nextStep = N - M;

        while (!deque.isEmpty()) {
            if (nextStep == deque.size()) {
                nextStep -= M;
                isClockwise = !isClockwise;
            }

            if (isClockwise) {
                firstRemoveAndAddLast(deque, K - 1);
                answer.add(deque.removeFirst());
            } else {
                lastRemoveAndAddFirst(deque, K - 1);
                answer.add(deque.removeLast());
            }
        }

        StringBuilder sb = new StringBuilder();
        answer.forEach(x -> sb.append(x).append('\n'));
        System.out.println(sb.substring(0, sb.length() - 1));
    }

    private static void firstRemoveAndAddLast(Deque<Integer> deque, int times) {
        for (int i = 0; i < times; i++) {
            deque.addLast(deque.removeFirst());
        }
    }

    private static void lastRemoveAndAddFirst(Deque<Integer> deque, int times) {
        for (int i = 0; i < times; i++) {
            deque.addFirst(deque.removeLast());
        }
    }
}
