#include <iostream>
#include <stdio.h>
#include <math.h>
#include <bitset>
#include <cstring>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

typedef pair<int, int> pii;

int n, l, r;
int sum, cnt, ans;
bool flag;

int map[51][51];
bool visit[51][51];

vector<pii> v;

int dx[4] = { 0,1,0,-1 };
int dy[4] = { 1,0,-1,0 };

void movePopulation() {
    int avg = sum / cnt;

    for (int i = 0; i < v.size(); i++) {
        int x = v[i].first;
        int y = v[i].second;
        map[x][y] = avg;
    }
}

void bfs(int i, int j) {
    queue<pii> q;
    q.push(pii(i, j));
    v.push_back(pii(i, j));
    visit[i][j] = true;
    sum += map[i][j];
    cnt++;

    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (visit[nx][ny]) continue;

            int sub = abs(map[x][y] - map[nx][ny]);
            if (sub >= l && sub <= r) {
                visit[nx][ny] = true;
                sum += map[nx][ny];
                cnt++;
                q.push(pii(nx, ny));
                v.push_back(pii(nx, ny));
            }
        }
    }
  
    if (v.size() > 1) {
        movePopulation();
        flag = true;
    }

    v.clear();
    sum = 0;
    cnt = 0;
}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> l >> r;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> map[i][j];
        }
    }

    ans = 0; sum = 0; cnt = 0;

    while (true) {
        memset(visit, false, sizeof(visit));
        flag = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    bfs(i, j);
                }
            }
        }

        if (flag) ans++;
        else break;
    }

    cout << ans << "\n";
}