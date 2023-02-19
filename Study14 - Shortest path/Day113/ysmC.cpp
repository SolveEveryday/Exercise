#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;
int n, m;
int dp[1001];
vector<pair <int, int>> road[1001];

void bfs(int start) {

    priority_queue<pair<int, int>,vector<pair<int,int>>, greater<pair<int,int>>> pq;
    pq.push({ 0, start });

    while (!pq.empty()) {
        int current = pq.top().second;
        int cost = pq.top().first;
        pq.pop();
        if (cost > dp[current]) {
            continue;
        }

        for (int i = 0; i < road[current].size(); i++) {
            int next = road[current][i].first;
            int next_cost = dp[current] + road[current][i].second;

            if (next_cost < dp[next]) {
                dp[next] = next_cost;
                pq.push({ next_cost,next });
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
        int a, b, c;
        cin >> a >> b >> c;
        road[a].push_back({ b,c });
    }
    int start, end;
    cin >> start >> end;
    fill_n(dp, 1001, 987654321);
    dp[start] = 0;
    bfs(start);

    cout << dp[end];

    return 0;
}