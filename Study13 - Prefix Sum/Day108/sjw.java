import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		int[][] sum = new int[26][200001];
		for (int i = 0; i < s.length(); i++) {
			sum[s.charAt(i) - 'a'][i+1]++;
		}
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < 26; j++) {
				sum[j][i] = sum[j][i-1] + sum[j][i];
			}
		}
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i=0; i<n; i++) {
			String[] line = br.readLine().split(" ");
			char a = line[0].charAt(0);
			int b = Integer.parseInt(line[1]);
			int c = Integer.parseInt(line[2]);
			sb.append(sum[a - 'a'][c+1] - sum[a - 'a'][b]).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}