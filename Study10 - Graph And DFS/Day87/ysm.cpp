#include<string.h>
#include <iostream>

using namespace std;

int testcaseN, N, M, K;
int dir[4][2] = {
	-1,0,
	0,-1,
	0,1,
	1,0
};
int ground[51][51];
int visited[51][51];

void dfs(int y, int x) {
	for (int z = 0; z < 4; z++) {
		int dy = y + dir[z][0];
		int dx = x + dir[z][1];
		if (dy < 0 || dx < 0 || dy >= N || dx >= M) continue;
		if (ground[dy][dx] && !visited[dy][dx]) {
			visited[dy][dx] = 1;
			dfs(dy, dx);
		}
	}
}
int main() {
	cin >> testcaseN;
	while (testcaseN) {
		cin >> N >> M >> K;
		int bug = 0;
		memset(ground, 0, sizeof(ground));
		memset(visited, 0, sizeof(visited));

		for (int x = 0; x < K; x++) {
			int a, b;
			cin >> a >> b;
			ground[a][b] = 1;
		}

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (!ground[y][x] || visited[y][x]) continue;
				visited[y][x] = 1;
				bug++;
				dfs(y, x);
				
			}
		}
		cout << bug <<"\n";
		testcaseN--;
	}

	
	return 0;
}




