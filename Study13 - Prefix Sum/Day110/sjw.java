public class Solution {
	public int solution(int[][] board, int[][] skill) {
		int N = board.length; //row
		int M = board[0].length; //col
		int action[][] = new int[N + 1][M + 1];

		for (int[] item : skill) {
			int type = item[0];
			int degree = item[5];

			int r1 = item[1];
			int c1 = item[2];

			int r2 = item[3];
			int c2 = item[4];

			if (type == 1) {
				action[r1][c1] += -degree;
				action[r1][c2 + 1] += degree;
				action[r2 + 1][c1] += degree;
				action[r2 + 1][c2 + 1] += -degree;
			} else {
				action[r1][c1] += degree;
				action[r1][c2 + 1] += -degree;
				action[r2 + 1][c1] += -degree;
				action[r2 + 1][c2 + 1] += degree;
			}
		}

		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += action[i][j];
				action[i][j] = sum;
			}
		}

		for (int i = 0; i < M; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				sum += action[j][i];
				action[j][i] = sum;
			}
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (action[i][j] + board[i][j] > 0) answer++;
			}
		}
		return answer;
	}
}