import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] sum = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			sum[i] = Integer.parseInt(br.readLine()) + sum[i - 1];
		}

		int answer = Integer.MIN_VALUE;

		for (int a = 1; a <= N; a++) {
			for (int b = a; b <= N; b++) {
				int clock = sum[b - 1] - sum[a - 1];
				int reverseClock = sum[N] - clock;

				answer = Math.max(answer, Math.min(clock, reverseClock));

				if (clock >= reverseClock) break;
			}
		}
		System.out.println(answer);
	}
}