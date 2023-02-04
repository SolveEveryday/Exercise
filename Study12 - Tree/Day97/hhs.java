package BOJ_2371;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int maxIndex = 0;
        List<List<Integer>> files = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            List<Integer> file = new ArrayList<>();

            while (st.hasMoreTokens()) {
                int value = Integer.parseInt(st.nextToken());

                if (value == -1) break;
                file.add(value);
            }
            files.add(file);
            maxIndex = Math.max(maxIndex, file.size());
        }

        int k = 1;

        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = maxIndex; i >= 0; i--) {
            set.clear();

            for (int j = 0; j < N; j++) {
                sb.setLength(0);
                for (int m = 0; m < i + 1; m++) {
                    int value;
                    try {
                        value = files.get(j).get(m);
                    } catch (IndexOutOfBoundsException e) {
                        value = 0;
                    }

                    sb.append(value);
                }

                set.add(sb.toString());
            }
            if (set.size() != N) {
                break;
            }
            k = i + 1;
        }

        System.out.println(k);
    }
}
