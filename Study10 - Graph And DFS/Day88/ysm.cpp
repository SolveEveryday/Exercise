#include <string>
#include <vector>
#include <iostream>
using namespace std;

void dfs(int start, vector<vector<int>> computers, vector<int> &visited) {
    visited[start] = 1;
    for (int y = 0; y < 3; y++) {
        if (computers[start][y] && !visited[y]) {
            visited[y] = 1;
            dfs(y, computers, visited);
        }
    }
}
int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    vector<int> visited(n, 0);
    for (int x = 0; x < n; x++) {
        if (!visited[x]) {
            answer++;
            visited[x] = 1;
            dfs(x, computers, visited);
        }
    }



    return answer;
}

int main() {
    int n = 3;
    vector<vector<int>> computers = { {1,1,0},{1,1,1},{0,1,1} };
    cout << solution(n, computers);
    return 0;
}