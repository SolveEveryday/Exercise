package BOJ_10799;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int result = 0;
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                deque.addLast(ch);
            } else {
                deque.removeLast();

                if (input.charAt(i - 1) == '(') {
                    result += deque.size();
                } else {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
