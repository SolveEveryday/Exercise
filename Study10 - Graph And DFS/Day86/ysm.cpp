#include<vector>
#include <iostream>
using namespace std;

int n, m;
vector<int> alist[101];
int cnt = 0;
int visited[101] = { 0 };
void dfs(int start) {

	for (int x = 0; x < alist[start].size(); x++) {
		int next = alist[start][x];
		if (visited[next] == 1) continue;
		cnt++;
		visited[next]++;
		dfs(next);

	}
}
int main() {
	cin >> n >> m;
	for (int x = 0; x < m; x++) {
		int a, b;
		cin >> a >> b;
		alist[a].push_back(b);
		alist[b].push_back(a);
	}
	visited[1] = 1;
	dfs(1);
	cout << cnt;
	return 0;
}




