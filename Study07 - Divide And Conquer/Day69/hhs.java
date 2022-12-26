import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[] result = new int[3];
    static int N;

    public static boolean isSame(int y, int x, int size) {
        int value = map[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (value != map[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void slice(int y, int x, int size) {
        if (isSame(y, x, size)) {
            result[map[y][x] + 1]++;
            return;
        }

        int newSize = size / 3;

        slice(y + newSize * 2, x, newSize);
        slice(y + newSize * 2, x + newSize, newSize);
        slice(y + newSize * 2, x + newSize * 2, newSize);
        slice(y + newSize, x, newSize);
        slice(y + newSize, x + newSize, newSize);
        slice(y + newSize, x + newSize * 2, newSize);
        slice(y, x, newSize);
        slice(y, x + newSize, newSize);
        slice(y, x + newSize * 2, newSize);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        slice(0, 0, N);
        Arrays.stream(result).forEach(System.out::println);
    }
}