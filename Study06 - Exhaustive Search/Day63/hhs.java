package Study06 - Exhaustive Search.Day63;

public class hhs {
    
}
package BOJ_12869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] orders = new int[][]{{-9,-3,-1}, {-9,-1,-3}, {-3,-9,-1}, {-3,-1,-9}, {-1,-9,-3}, {-1,-3,-9}};
    static int[][][] visit = new int[61][61][61];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] scv = new int[3];

        for (int i = 0; i < N; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }

        dfs(scv, 0);

        System.out.println(min);
    }

    public static void dfs(int[] scv, int depth) {
        int s1 = scv[0];
        int s2 = scv[1];
        int s3 = scv[2];

        if (min <= depth) {
            return;
        }

        if (visit[s1][s2][s3] != 0 && visit[s1][s2][s3] <= depth) {
            return;
        }

        visit[s1][s2][s3] = depth;

        if (s1 == 0 && s2 == 0 && s3 == 0) {
            min = Math.min(min, depth);
            return;
        }

        for (int i = 0; i < 6; i++) {
            dfs(new int[]{Math.max(s1 + orders[i][0], 0), Math.max(s2 + orders[i][1], 0), Math.max(s3 + orders[i][2], 0)}, depth + 1);
        }
    }
}
