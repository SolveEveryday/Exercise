#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int n, m, r;
queue<int>q;
int result[100001];
int cnt = 2;
void bfs(int start, vector<vector<int>> &alist, vector<int> &visited) {
    visited[start] = 1;
    q.push(start);
    
    while (!q.empty()) {
        int now = q.front();
        q.pop();
      
        for (int x = 0; x < alist[now].size(); x++) {
            if (visited[alist[now][x]] == 1) continue;
            visited[alist[now][x]] = 1;
            result[alist[now][x]] = cnt++;
            q.push(alist[now][x]);
        }
    }
}
int main() {
    cin >> n >> m >> r;
    vector<vector<int>> alist(n+1);
    vector<int> visited(n+1);
    for (int x = 0; x < m; x++) {
        int a, b;
        cin >> a >> b;
        alist[a].push_back(b);
        alist[b].push_back(a);
    }

    for (int x = 1; x <= n; x++) {
        sort(alist[x].begin(), alist[x].end());

    }
    result[r] = 1;
    bfs(r, alist, visited);
    

    for (int x = 1; x <= n; x++) {
        cout << result[x] << "\n";
    }

    
    return 0;
}