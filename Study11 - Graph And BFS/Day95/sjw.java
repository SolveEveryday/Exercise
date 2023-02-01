import java.util.*;

public class Solution {

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static int N;
	public static int[][][] visited; // 방문처리 겸 비용정보 저장배열
	public static int answer = Integer.MAX_VALUE;


	public int solution(int[][] board) {
		N = board.length;
		visited = new int[N][N][4];

		for (int i = 0; i < N; i++){
			for (int j = 0; j < N; j++){
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
			}
		}

		return bfs(board);
	}

	public static int bfs(int[][] board){
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0,0,-1,-500));

		while(!queue.isEmpty()) {
			Point nowPoint = queue.poll();

			int cx = nowPoint.x;
			int cy = nowPoint.y;
			int cd = nowPoint.dir;
			int cost = nowPoint.cost;

			if (cx == N - 1 && cy == N - 1) {
				answer = Math.min(answer, cost);
				continue;
			}

			for(int i = 0; i < 4; i++) {

				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 1) continue;

				if (cd == i && visited[nx][ny][i] > cost + 100) {
					visited[nx][ny][i] = cost + 100;
					queue.add(new Point(nx, ny, i, cost + 100));

				} else if (cd != i && visited[nx][ny][i] > cost + 600) {
					visited[nx][ny][i] = cost + 600;
					queue.add(new Point(nx, ny, i, cost + 600));
				}
			}
		}
		return answer;
	}
	public static class Point {
		int x;
		int y;
		int dir;
		int cost;

		Point(int x, int y, int dir, int cost) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cost = cost;
		}
	}

	public static void main(String[] args) {

		int[][] testCase25 = {
			{0, 0, 0, 0, 0},
			{0, 1, 1, 1, 0},
			{0, 0, 1, 0, 0},
			{1, 0, 0, 0, 1},
			{0, 1, 1, 0, 0}
		};
		// [3][3] = 1 - 2100 ,2 -2300
		//1 -3300 2- 3000


		Solution d = new Solution();
		int solution = d.solution(testCase25);
		System.out.println(solution);
	}
}
