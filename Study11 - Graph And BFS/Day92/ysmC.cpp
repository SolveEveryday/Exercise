#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int dir[4][2] = {
    -1,0,
    0,-1,
    0,1,
    1,0
};
int n, m;
queue<pair<int, int>> q;
int visited[101][101];
int input[101][101];
int cnt = 0;
int dist[101][101];
void check(int starty, int startx) {
    q.push(make_pair(starty, startx));
    visited[starty][startx] = 1;
    dist[starty][startx]++;
    while (!q.empty()) {
        int nowy = q.front().first;
        int nowx = q.front().second;
        q.pop();

        for (int x = 0; x < 4; x++) {
            int dy = nowy + dir[x][0];
            int dx = nowx + dir[x][1];

            if (dy < 0 || dx < 0 || dy >= n || dx >= m) continue;
            if (input[dy][dx] == 0) continue;
            if (visited[dy][dx] == 1) continue;
            visited[dy][dx] = 1;
            dist[dy][dx] = dist[nowy][nowx] + 1;
            q.push(make_pair(dy, dx));

        }
    }
}
int main() {

    cin >> n >> m;


    for (int y = 0; y < n; y++) {
        string value;
        cin >> value;
        for (int x = 0; x < m; x++) {
            input[y][x] = value[x] - '0';
        }
    }

    check(0, 0);
    cout << dist[n - 1][m - 1];
    return 0;
}