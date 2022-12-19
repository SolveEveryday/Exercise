package BOJ_1174;

import java.util.*;

public class Main {
    static Set<String> set = new HashSet<>();
    static char[] numbers = new char[]{'9', '8', '7', '6', '5', '4', '3', '2', '1', '0'};

    public static void main(String[] args) {
        dfs(0, "");
        List<String> list = new ArrayList<>(set);
        list.sort((a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });

        Scanner sc = new Scanner(System.in);

        String answer;

        try {
            answer = list.get(sc.nextInt());
        } catch (IndexOutOfBoundsException e) {
            answer = "-1";
        }

        System.out.println(answer);
    }

    static void dfs(int depth, String value) {
        if (depth == 10) {
            set.add(value);
            return;
        }

        dfs(depth + 1, value + "");

        for (int i = 0; i < 10; i++) {
            if (value.isBlank() || value.charAt(value.length() - 1) > numbers[i]) {
                dfs(depth + 1, value + numbers[i]);
            }
        }
    }
}
