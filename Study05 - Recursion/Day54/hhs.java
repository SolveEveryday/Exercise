package BOJ_2448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<String> stars = new ArrayList<>();

    public static void makeStar(int spaceCount) {
        int length = stars.size();

        for (int i = 0; i < length; i++) {
            stars.add(stars.get(i) + stars.get(i));

            String blank = "   ".repeat(spaceCount);
            stars.set(i, blank + stars.get(i) + blank);
        }
    }

    static int log2(int x) {
        return (int) (Math.log10(x) / Math.log10(2));
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = log2(N / 3);

        stars.add("  *   ");
        stars.add(" * *  ");
        stars.add("***** ");

        for (int i = 0; i < K; i++) {
            makeStar((int) Math.pow(2, i));
        }

        StringBuilder sb = new StringBuilder();
        for (String star : stars) {
            sb.append(star).append('\n');
        }
        System.out.println(sb);
    }
}
