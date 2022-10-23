package BOJ_1822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());

        TreeSet<Integer> treeSet = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            treeSet.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            int value = Integer.parseInt(st.nextToken());
            treeSet.remove(value);

        }

        StringBuilder sb = new StringBuilder();
        treeSet.forEach(x -> sb.append(x).append(' '));

        System.out.println(treeSet.size());
        System.out.println(sb.toString().trim());
    }
}
