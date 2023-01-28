#include <iostream>
#include <queue>
#include <cstring>
#include <string>
using namespace std;

int dir[4][2] = {
	-1,0,
	1,0,
	0,-1,
	0,1
	
};

struct MoveM {
	int y, x;
	int direction;
	int cost;
};
int answer[4][26][26];

int solution(vector<vector<int>> board) {
	int result = 9999999;
	queue<MoveM> q;
	int n = board.size();
	q.push({ 0,0,1,0 });
	q.push({ 0,0,3,0 });

	
	memset(answer, 9999999, sizeof(answer));
	while (!q.empty()) {
		MoveM now = q.front();
		q.pop();
		
		if (now.y == n - 1 && now.x == n - 1) {
			result = min(result, now.cost);
		}

		for (int x = 0; x < 4; x++) {
			int dy = now.y + dir[x][0];
			int dx = now.x + dir[x][1];
			
			if (dy < 0 || dx < 0 || dy >= n || dx >= n ) continue;
			if (board[dy][dx] == 1) continue;
			int money = 0;
			if (x == now.direction || now.direction == 5) money = now.cost + 100;
			else money = now.cost + 600;

			if ( money <= answer[x][dy][dx]) {
				answer[x][dy][dx] = money;
				q.push({ dy,dx,x, money});
			}
		}
	}
	
	return result;

}