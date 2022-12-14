import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] matrix;
    static int white = 0;
    static int blue = 0;

    public static void slice(int y, int x, int size) {
        if (checkColor(y, x, size)) {
            if (matrix[y][x] == 0) {
                white++;
            } else {
                blue++;
            }

            return;
        }

        int newSize = size / 2;

        slice(y, x, newSize);
        slice(y, x + newSize, newSize);
        slice(y + newSize, x, newSize);
        slice(y + newSize, x + newSize, newSize);
    }

    public static boolean checkColor(int y, int x, int size) {
        int color = matrix[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (color != matrix[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        slice(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }
}
