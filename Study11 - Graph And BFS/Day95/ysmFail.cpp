#include <string>
#include <vector>
#include <queue>
using namespace std;

int dir[4][2] = {
    -1,0,
    1,0,
    0,-1,
    0,1
};
struct Car {
    int r, c, direct, cost;
};

queue<Car> q;

int solution(vector<vector<int>> board) {
    int answer = 99999;
    int n = board.size();
    q.push({ 0,0,4,0 });
    board[0][0] = 1;

    while (!q.empty()) {
        Car car = q.front();
        q.pop();
        int cost = car.cost;
        if (car.c == n - 1 && car.r == n - 1) {
            if (cost < answer) answer = cost;
            continue;
        }

        for (int x = 0; x < 4; x++) {
            int dy = car.r + dir[x][0];
            int dx = car.c + dir[x][1];

            if (dy < 0 || dx < 0 || dy >= n || dx >= n || board[dy][dx] == 1) {
                continue;
            }

            int newCost = cost;
            if (x == car.direct || (car.c == 0 && car.r == 0 )) {
                newCost += 100;
            }
            else {
                newCost += 600;
            }
            if (board[dy][dx] == 0 || board[dy][dx] >= newCost) {
                q.push({ dy,dx,x,newCost });
                board[dy][dx] = newCost;
            }
        }
    }
    return answer;
}