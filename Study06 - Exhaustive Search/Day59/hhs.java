import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] numbers = new int[9];
        int sum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
        }
        Arrays.sort(numbers);

        loop: for (int i = 0; i < 8; i++) {
            for (int j = 1; j < 9; j++) {
                if (sum - numbers[i] - numbers[j] == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k == i || k == j)
                            continue;
                        System.out.println(numbers[k]);
                    }
                    break loop;
                }
            }
        }
    }
}
