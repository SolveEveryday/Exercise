package pro_60058;

import java.util.Stack;

public class Solution {
    public static boolean isBalance(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(c);
                continue;
            }

            if (stack.peek() == '(' && c == ')') {
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        return stack.isEmpty();
    }

    public static String solution(String p) {
        if (p.isBlank() || isBalance(p)) {
            return p;
        }

        String answer = "";
        String u = "";
        String v = "";

        int countOpen = 0;
        int countClose = 0;
        for (char c : p.toCharArray()) {
            if (c == '(')
                countOpen++;
            else
                countClose++;

            u += c;
            if (countOpen == countClose)
                break;
        }

        v = p.substring(countOpen + countClose);

        if (isBalance(u)) {
            answer += u + solution(v);
        } else {
            answer += "(" + solution(v) + ")";
            char[] uCharArray = u.toCharArray();

            for (int i = 1; i < uCharArray.length - 1; i++) {
                char c = uCharArray[i];
                if (c == '(')
                    answer += ")";
                else
                    answer += "(";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("()))((()"));
    }
}
