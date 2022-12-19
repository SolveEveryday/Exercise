import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int min = 64;
    public static boolean[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        matrix = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                if (temp.charAt(j) == 'W') {
                    matrix[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                find(i, j);
            }
        }

        System.out.println(min);
    }

    public static void find(int x, int y) {
        int endX = x + 8;
        int endY = y + 8;
        int count = 0;
        boolean value = matrix[x][y];

        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                if (value != matrix[i][j]) {
                    count++;
                }

                value = !value;
            }
            value = !value;
        }

        count = Math.min(count, 64 - count);
        min = Math.min(count, min);
    }
}
