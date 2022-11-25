package BOJ_5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String command = br.readLine();
            int N = Integer.parseInt(br.readLine());
            Deque deque = convert(N, br.readLine());
            System.out.println(solution(command, deque));
        }

    }

    public static String solution(String command, Deque<Integer> deque) {
        // true면 왼쪽, false면 오른쪽
        boolean direction = true;

        for (char ch : command.toCharArray()) {
            if (ch == 'R') {
                direction = !direction;
            } else {
                try {
                    if (direction) {
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                } catch (NoSuchElementException e) {
                    return "error";
                }
            }
        }

        StringBuilder sb = new StringBuilder("[");

        while (!deque.isEmpty()) {
            if (direction) {
                sb.append(deque.removeFirst());
            } else {
                sb.append(deque.removeLast());
            }

            if (!deque.isEmpty()) {
                sb.append(",");
            }
        }

        sb.append("]");

        return sb.toString();
    }

    public static Deque<Integer> convert(int N, String arrString) {
        if (N == 0) {
            return new ArrayDeque<>();
        }

        arrString = arrString.substring(1, arrString.length() - 1);
        List<Integer> list = Arrays.stream(arrString.split(",")).mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toList());

        return new ArrayDeque<>(list);
    }
}
