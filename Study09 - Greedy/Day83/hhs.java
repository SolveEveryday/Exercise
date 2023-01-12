package BOJ_1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            int digit = 0;
            for (int j = word.length() - 1; j >= 0; j--) {
                char key = word.charAt(j);
                int value = (int) Math.pow(10, digit);

                if (map.containsKey(key)) {
                    map.merge(key, value, Integer::sum);
                } else {
                    map.put(key, value);
                }

                digit++;
            }
        }

        List<Integer> values = map.values().stream().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        long answer = 0;

        int priority = 9;
        for (int value : values) {
            answer += (long) value * (priority--);
        }

        System.out.println(answer);
    }
}
