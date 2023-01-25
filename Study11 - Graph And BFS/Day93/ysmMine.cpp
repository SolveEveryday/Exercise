#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int n, m, k;
int v[51][51];
int result[51][51];
int visited[51][51];
int dir[4][2] = {
    -1,0,
    0,-1,
    0,1,
    1,0
};
int sum = 0;
int cnt = 0;
queue<int> q;
int moveCnt = 0;
int flag = 0;
void calcul() {
    int num = sum / cnt;
  
    moveCnt++;
    for (int y = 0; y < n; y++) {
        for (int x = 0; x < n; x++) {
            if (result[y][x] == 1) v[y][x] = num;
        }
    }

   
}

void check() {
    fill(&result[0][0], &result[50][50], 0);
    fill(&visited[0][0], &visited[50][50], 0);
    sum = 0;
    cnt = 0;

    for (int y = 0; y < n; y++) {
        for (int x = 0; x < n; x++) {
            if (visited[y][x] == 1) continue;
            for (int z = 0; z < 4; z++) {
                int dy = y + dir[z][0];
                int dx = x + dir[z][1];
                if (dy < 0 || dx < 0 || dx >= n || dy >= n) continue;
                int value = abs(v[dy][dx] - v[y][x]);
                if (value >= m && value <= k) {
                    visited[dy][dx] = 1;
                    result[y][x] = 1;
                    sum += v[y][x];
                    cnt++;
                    break;
                }
            }
        }
    }
    if (cnt < 2) {
        flag = 1;
        return;
    }
    calcul();
}
int main() {
    cin >> n >> m >> k;
    for (int y = 0; y < n; y++) {
        for (int x = 0; x < n; x++) {
            cin >> v[y][x];
        }
    }

    while (!flag) {
        check();
    }
  

    cout << moveCnt;
    return 0;
}