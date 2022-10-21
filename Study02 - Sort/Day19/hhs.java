package BOJ_17140;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] matrix;
    static int[][] temp = new int[101][101];
    static int maxRow;
    static int maxCol;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        matrix = new int[3][3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxRow = 3;
        maxCol = 3;
        int answer = 0;

        while (true) {
            if (answer > 100) {
                answer = -1;
                break;
            }

            try {
                int value = matrix[r][c];
                if (value == k) break;
            } catch (ArrayIndexOutOfBoundsException ignored) {}

            if (maxRow >= maxCol) {
                R();
            } else {
                C();
            }

            temp = new int[101][101];

            answer++;
        }

        System.out.println(answer);
    }

    private static void copy() {
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(temp[i], 0, matrix[i], 0, matrix[i].length);
        }
    }

    private static void R() {
        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            int[] countNumber = new int[101];

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) continue;
                countNumber[matrix[i][j]]++;
            }

            List<NumberInfo> numberInfos = new ArrayList<>();

            for (int j = 1; j <= 100; j++) {
                if (countNumber[j] == 0) continue;
                numberInfos.add(new NumberInfo(j, countNumber[j]));
            }

            Collections.sort(numberInfos);
            List<Integer> values = new ArrayList<>();
            numberInfos.forEach(numberInfo -> {
                values.add(numberInfo.number);
                values.add(numberInfo.countNumber);
            });

            for (int j = 0; j < values.size(); j++) {
                temp[i][j] = values.get(j);
            }

            max = Math.min(Math.max(max, values.size()), 100);
        }

        maxCol = max;
        matrix = new int[maxRow][maxCol];

        copy();
    }

    private static void C() {
        int max = 0;

        for (int i = 0; i < matrix[0].length; i++) {
            int[] countNumber = new int[101];

            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 0) continue;
                countNumber[matrix[j][i]]++;
            }

            List<NumberInfo> numberInfos = new ArrayList<>();

            for (int j = 1; j <= 100; j++) {
                if (countNumber[j] == 0) continue;
                numberInfos.add(new NumberInfo(j, countNumber[j]));
            }

            Collections.sort(numberInfos);
            List<Integer> values = new ArrayList<>();
            numberInfos.forEach(numberInfo -> {
                values.add(numberInfo.number);
                values.add(numberInfo.countNumber);
            });

            for (int j = 0; j < values.size(); j++) {
                temp[j][i] = values.get(j);
            }

            max = Math.min(Math.max(max, values.size()), 100);
        }

        maxRow = max;
        matrix = new int[maxRow][maxCol];

        copy();
    }
}

class NumberInfo implements Comparable<NumberInfo> {
    int number;
    int countNumber;

    public NumberInfo(int number, int countNumber) {
        this.number = number;
        this.countNumber = countNumber;
    }

    @Override
    public int compareTo(NumberInfo o) {
        if (countNumber - o.countNumber == 0) {
            return number - o.number;
        }

        return countNumber - o.countNumber;
    }
}