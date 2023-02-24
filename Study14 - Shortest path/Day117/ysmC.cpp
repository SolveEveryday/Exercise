#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#define INF 987654321

using namespace std;

int n, m;
int graph[100][100];
int dir[4][2] = { {1,0},{0,1},{-1,0},{0,-1} };
int dp[100][100];

void djikstra(int r, int c) {

    dp[r][c] = 0;
    priority_queue<pair<int,pair<int, int>>, vector<pair<int,pair<int, int>>>, greater<pair<int,pair<int, int>>>> pq;
    pq.push({ 0,{r,c} });

    while (!pq.empty()) {
        int count = pq.top().first;
        int current_r = pq.top().second.first;
        int current_c = pq.top().second.second;
        pq.pop();
        if (dp[current_r][current_c] < count)
            continue;

        for (int i = 0; i < 4; i++) {
            int next_count;
            int next_r = current_r + dir[i][0];
            int next_c = current_c + dir[i][1];

            if (next_r >= 0 && next_r < m && next_c >= 0 && next_c < n) {
                if (graph[next_r][next_c] == 0) {

                    next_count = dp[current_r][current_c];
                }
                else {
                    next_count = dp[current_r][current_c] + 1;
                }
                if (dp[next_r][next_c] > next_count) {
                    pq.push({ next_count,{next_r,next_c} });
                    dp[next_r][next_c] = next_count;
                }
            }

        }



    }

}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> n >> m;


    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            char ch;
            cin >> ch;
            graph[i][j] = ch-'0';
        }
    }

    for (int i = 0; i < 100; i++) {
        for (int j = 0; j < 100; j++) {
            dp[i][j] = INF;
        }
    }

    djikstra(0, 0);

    cout << dp[m - 1][n - 1];

    return 0;
}