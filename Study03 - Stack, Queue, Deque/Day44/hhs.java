package BOJ_19591;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        StringBuilder sb = new StringBuilder();
        Deque<String> deque = new ArrayDeque<>();

        if (Character.isDigit(command.charAt(0))) {
            command = "+" + command;
        }

        for (char ch : command.toCharArray()) {
            if (!Character.isDigit(ch) && sb.length() != 0) {
                deque.addLast(sb.toString());
                sb.setLength(0);
            }

            sb.append(ch);
        }

        deque.addLast(sb.toString());

        while (deque.size() > 2) {
            String temp = deque.pollFirst();
            String[] aExpression = new String[] {temp, deque.peekFirst()};
            deque.addFirst(aExpression[0]);
            temp = deque.pollLast();
            String[] bExpression = new String[] {deque.peekLast(), temp};
            deque.addLast(bExpression[1]);

            String a, b;
            if (compareOperator(aExpression, bExpression)) {
                a = deque.pollFirst();
                b = deque.pollFirst();
                deque.addFirst(convert(a, b, true));
            } else {
                b = deque.pollLast();
                a = deque.pollLast();
                deque.addLast(convert(a, b, false));
            }
        }

        String answer;
        if (deque.size() == 2) {
            answer = convert(deque.pollFirst(), deque.pollFirst(), true);
        } else {
            answer = deque.pollFirst();
        }

        if (answer.charAt(0) != '-') {
            answer = answer.substring(1);
        }

        System.out.println(new BigInteger(answer));
    }

    // a가 크면 true b가 크면 false
    public static boolean compareOperator(String[] aExpression, String[] bExpression) {
        char aExpressionOperator = aExpression[1].charAt(0);
        char bExpressionOperator = bExpression[1].charAt(0);

        if ((aExpressionOperator == '*' || aExpressionOperator == '/')
                && (bExpressionOperator == '+' || bExpressionOperator == '-')) {
            return true;
        } else if ((aExpressionOperator == '+' || aExpressionOperator == '-')
                && (bExpressionOperator == '*' || bExpressionOperator == '/')) {
            return false;
        } else {
            String aResult = convert(aExpression[0], aExpression[1], true);

            if (aResult.charAt(0) != '-') {
                aResult = aResult.substring(1);
            }

            String bResult = convert(bExpression[0], bExpression[1], false).substring(1);

            return (new BigInteger(aResult).compareTo(new BigInteger(bResult))) >= 0;
        }
    }

    public static String convert(String a, String b, boolean isFirst) {
        char leftOperator = a.charAt(0);
        BigInteger leftOperand;

        if (isFirst && leftOperator == '-') {
            leftOperand = new BigInteger(a);
        } else {
            leftOperand = new BigInteger(a.substring(1));
        }

        char rightOperator = b.charAt(0);
        BigInteger rightOperand = new BigInteger(b.substring(1));

        BigInteger result = calculator(leftOperand, rightOperand, rightOperator);

        String answer = result.toString();

        if (result.compareTo(BigInteger.ZERO) >= 0) {
            answer = leftOperator + answer;
        }

        return answer;
    }

    public static BigInteger calculator(BigInteger a, BigInteger b, char operator) {
        switch (operator) {
            case '+':
                return a.add(b);
            case '-':
                return a.subtract(b);
            case '*':
                return a.multiply(b);
            default:
                return a.divide(b);
        }
    }
}

