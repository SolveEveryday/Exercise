#include <string>
#include <vector>
#include <iostream>
using namespace std;



int n, m;
int cnt = 0;
int flag = 0;

void dfs(int start, vector<int>& visited, vector<vector<int>> &alist) {

    visited[start] = 1;
    if (cnt == 4) {
        flag = 1;
        return;
    }
    for (int x = 0; x < alist[start].size(); x++) {
        int next = alist[start][x];
        if (visited[next] == 1) continue;
        cnt++;
        visited[next] = 1;
        dfs(next, visited, alist);
        visited[next] = 0;
        cnt--;
    }
}
int main() {
   
    cin >> n >> m;
    vector<int> visited(n);
    vector<vector<int>> alist(n, vector<int>());
  
    for (int x = 0; x < m; x++) {
        int a, b;
        cin >> a >> b;
        alist[a].push_back(b);
        alist[b].push_back(a);
    }

    for (int y = 0; y < n; y++) {
      
        dfs(y,visited, alist);
        visited[y] = 0;
        if (flag == 1) {
            cout << flag;
            break;
        }
    }

    if (!flag) cout << flag;
    return 0;
}