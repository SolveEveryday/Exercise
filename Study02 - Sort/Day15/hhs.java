import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int[] sortNumbers = new int[n];
        int[] numbersIndex = new int[10001];
        int max = 0;

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            numbers[i] = temp;
            numbersIndex[temp]++;

            if (temp > max) {
                max = temp;
            }
        }

        for (int i = 1; i <= max; i++) {
            numbersIndex[i] += numbersIndex[i - 1];
        }

        for (int i = numbers.length - 1; i >= 0; i--) {
            int temp = numbers[i];
            sortNumbers[--numbersIndex[temp]] = temp;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sortNumbers.length; i++) {
            sb.append(sortNumbers[i]).append("\n");
        }

        System.out.println(sb);
    }
}
