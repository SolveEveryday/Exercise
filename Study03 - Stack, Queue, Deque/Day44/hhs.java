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
        Deque<BigInteger> numberDeque = new ArrayDeque<>();
        Deque<Character> operatorDeque = new ArrayDeque<>();

        if (command.charAt(0) == '-') {
            sb.append('-');
            command = command.substring(1);
        }

        for (char ch : command.toCharArray()) {
            if (!Character.isDigit(ch) && sb.length() != 0) {
                numberDeque.addLast(new BigInteger(sb.toString()));
                operatorDeque.addLast(ch);
                sb.setLength(0);
                continue;
            }

            sb.append(ch);
        }
        numberDeque.addLast(new BigInteger(sb.toString()));

        while (!operatorDeque.isEmpty()) {
            BigInteger temp = numberDeque.pollFirst();
            BigInteger[] aValue = new BigInteger[] {temp, numberDeque.peekFirst()};
            numberDeque.addFirst(temp);
            temp = numberDeque.pollLast();
            BigInteger[] bValue = new BigInteger[] {numberDeque.peekLast(), temp};
            numberDeque.addLast(temp);

            BigInteger a, b;
            Character operator;
            if (compareOperator(operatorDeque.peekFirst(), aValue, operatorDeque.peekLast(), bValue)
                    && operatorDeque.size() > 1) {
                a = numberDeque.pollFirst();
                b = numberDeque.pollFirst();
                operator = operatorDeque.pollFirst();

                numberDeque.addFirst(calculator(a, b, operator));
            } else {
                b = numberDeque.pollLast();
                a = numberDeque.pollLast();
                operator = operatorDeque.pollLast();

                numberDeque.addLast(calculator(a, b, operator));
            }
        }

        System.out.println(numberDeque.poll());
    }

    public static boolean compareOperator(Character a, BigInteger[] aValue, Character b,
            BigInteger[] bValue) {
        if ((a == '*' || a == '/') && (b == '+' || b == '-')) {
            return true;
        } else if ((a == '+' || a == '-') && (b == '*' || b == '/')) {
            return false;
        } else {
            BigInteger aResult = calculator(aValue[0], aValue[1], a);
            BigInteger bResult = calculator(bValue[0], bValue[1], b);

            return (aResult.compareTo(bResult)) >= 0;
        }
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
