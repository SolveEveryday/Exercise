package BOJ_1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static int N, r, c;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int powValue = (int) Math.pow(2, N);
        matrix = new int[powValue][powValue];
        R(0, 0, powValue - 1, powValue - 1);

        System.out.println(matrix[r][c]);
    }

    public static void R(int rS, int cS, int rE, int cE) {
        if (rE - rS == 1 && cE - cS == 1) {
            matrix[rS][cS] = count++;
            return;
        }

        R(rS, cS, rE / 2, cE / 2);
        R(rS, (cE / 2) + 1, rE / 2, cE);
        R((rE / 2) + 1, cS, rE, cE / 2);
        R((rE / 2) + 1, (cE / 2) + 1, rE, cE);
    }
}
