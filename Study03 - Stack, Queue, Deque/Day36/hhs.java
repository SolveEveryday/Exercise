package BOJ_2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        Deque<Character> deque = new ArrayDeque<>();

        int answer = 0;
        int temp = 1;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int value = ((ch == '(') ? 2 : 3);

            if (deque.isEmpty()) {
                deque.addLast(ch);
                temp *= value;
                continue;
            }

            if ((deque.peekLast() == '(' && ch == ')') || (deque.peekLast() == '[' && ch == ']')) {
                if (!(chars[i - 1] == ']' || chars[i - 1] == ')')) {
                    answer += temp;
                }
                temp /= (ch == ')') ? 2 : 3;
                deque.removeLast();
            } else {
                temp *= value;
                deque.addLast(ch);
            }
        }

        System.out.println((deque.size() == 0) ? answer : 0);

    }
}
