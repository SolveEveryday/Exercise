import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<List<Integer>> files = new ArrayList<>();

		//fileInfo
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			List<Integer> file = new ArrayList<>();
			for (String s : line) {
				int x = Integer.parseInt(s);
				if (x == -1) {
					break;
				}
				file.add(x);
			}
			files.add(file);
		}

		int left = 0, right = Integer.MAX_VALUE;
		while (left < right) {
			int mid = (left + right) / 2;
			if (isDistinguishable(files, mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(right);
	}

	private static boolean isDistinguishable(List<List<Integer>> files, int k) {
		Set<String> prefixes = new HashSet<>();
		for (List<Integer> file : files) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < k && i < file.size(); i++) {
				sb.append(file.get(i));
			}
			prefixes.add(sb.toString());
		}
		return prefixes.size() == files.size();
	}
}
