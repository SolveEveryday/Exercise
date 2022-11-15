package BOJ_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            boolean answer = checkBracket(br.readLine());

            System.out.println((answer) ? "YES" : "NO");
        }
    }

    public static boolean checkBracket(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (deque.isEmpty()) {
                deque.addLast(c);
                continue;
            }

            if (c == ')' && deque.peekLast() == '(') {
                deque.removeLast();
            } else {
                deque.add(c);
            }
        }

        return deque.isEmpty();
    }
}
