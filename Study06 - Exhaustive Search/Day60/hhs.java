package BOJ_5568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static String[] values;
    static Set<String> set = new HashSet<>();
    static boolean[] check;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        values = new String[n];
        check = new boolean[n];

        for (int i = 0; i < n; i++) {
            values[i] = br.readLine();
        }

        combination(0, "");

        System.out.println(set.size());
    }

    public static void combination(int depth, String value) {
        if (depth == k) {
            set.add(value);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check[i]) continue;
            check[i] = true;
            combination(depth + 1, value + values[i]);
            check[i] = false;
        }
    }
}
