#include <iostream>
#include <vector>
#include <string>
#include <queue>
using namespace std;

int dir[4][2] = {
	-1,0,
	0,-1,
	0,1,
	1,0
};
struct MoveV {
	int y,x;
};

int map[101][101];
int result[101][101];
int visited[101][101];
int main() {
	int n, m;
	cin >> n >> m;
	
	for (int y = 0; y < n; y++) {
		string value;
		cin >> value;
		for (int x = 0; x < m; x++) {
			map[y][x] = value[x] - '0';
		}
	}
	queue<MoveV> q;
	q.push({ 0,0 });
	visited[0][0] = 1;
	result[0][0] = 1;
	while (!q.empty()) {
		MoveV now = q.front();
		q.pop();
		for (int x = 0; x < 4; x++) {
			int dy = now.y + dir[x][0];
			int dx = now.x + dir[x][1];

			if (dy < 0 || dx < 0 || dy >= n || dx >= m) continue;
			if (map[dy][dx] == 0 || visited[dy][dx] == 1) continue;
			visited[dy][dx] = 1;
			result[dy][dx] = result[now.y][now.x] + 1;
			q.push({ dy,dx });
		}
	}

	cout << result[n - 1][m - 1];
	return 0;
}