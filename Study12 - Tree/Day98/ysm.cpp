#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

long long n;
long long maxMove;
int visited[5001];
void dfs(long long now, long long weightSum, vector<vector<pair<long long, long long>>>& alist) {

	if (weightSum > maxMove) {
		maxMove = weightSum;
	}
	

	for (int x = 0; x < alist[now].size(); x++) {
		long long next = alist[now][x].first;
		long long addweight = alist[now][x].second;
		if (visited[next] == 1) continue;
		visited[next] = 1;
		
		dfs(next, weightSum + addweight, alist);
		visited[next] = 0;
	}
}

int main() {
	
	cin >> n;
	vector<vector<pair<long long, long long>>> alist(n+1);
	for (int x = 0; x < n - 1; x++) {
		int a, b, weight;
		cin >> a >> b >> weight;
		alist[a].push_back({ b,weight });
		alist[b].push_back({ a,weight });
	}
	visited[1] = 1;
	dfs(1,0, alist);
	cout << maxMove;
	return 0;
   
}