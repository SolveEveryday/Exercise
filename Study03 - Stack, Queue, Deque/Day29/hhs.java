package BOJ_11899;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (deque.isEmpty()) {
                deque.add(c);
                continue;
            }

            if (deque.peekLast() == '(' && c == ')') {
                deque.pollLast();
            } else {
                deque.add(c);
            }
        }

        System.out.println(deque.size());
    }
}
