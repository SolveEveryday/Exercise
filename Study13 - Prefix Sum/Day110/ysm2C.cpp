#include <string>
#include <vector>

using namespace std;

int attack[1001][1001];
int solution(vector<vector<int>> board, vector<vector<int>> skill) {
	
	int N = board.size();
	int M = board[0].size();

	for (int x = 0; x < skill.size(); x++) {
		int type = skill[x][0];
		int r1 = skill[x][1];
		int c1 = skill[x][2];
		int r2 = skill[x][3];
		int c2 = skill[x][4];
		int degree = skill[x][5];

		if (type == 1) degree = -degree;
		attack[r1][c1] += degree;
		attack[r2+1][c2+1] += degree;
		attack[r2 + 1][c1] += -degree;
		attack[r1][c2 + 1] += -degree;
	}

	for (int y = 0; y < N+1; y++) {
		for (int x = 0; x < M; x++) {
			attack[y][x+1] += attack[y][x];
		}
	}

	for (int y = 0; y < N; y++) {
		for (int x = 0; x < M+1; x++) {
			attack[y+1][x] += attack[y][x];
		}
	}

	int cnt = 0;
	for (int y = 0; y < N; y++) {
		for (int x = 0; x < M; x++) {
			if (board[y][x] + attack[y][x] > 0) cnt++;
		}
	}

	return cnt;
}