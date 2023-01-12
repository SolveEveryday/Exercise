#include<vector>
#include <iostream>
#include <algorithm>
using namespace std;

int n, m, r;
int visited[200000];
int order[200000];
int t = 1;
vector<int> alist[100001];
void dfs(int start) {

	if (visited[start] == 1) return;
	visited[start] = 1;
	order[start] = t++;

	sort(alist[start].begin(), alist[start].end());

	for (int x = 0; x < alist[start].size(); x++) {
		int next = alist[start][x];
	
		dfs(next);
	}
	
}
int main() {
	
	cin >> n >> m >> r;

	for (int x = 1; x <= m; x++) {
		int a, b;
		cin >> a >> b;
		alist[a].push_back(b);
		alist[b].push_back(a);
	}
	
	dfs(r);
	for (int x = 1; x <= n; x++) {
		cout << order[x]<<"\n";
	}
	return 0;
}




