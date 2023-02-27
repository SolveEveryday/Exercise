#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int n, k, m;
vector < pair<int, int>> alist[1001];
int d[1001]; 
int result;
void dijkstra(int start, int end) {
	
	memset(d, 98765432, sizeof(d));
	d[start] = 0;
	priority_queue<pair<int, int>, vector<pair<int,int>>, greater<pair<int,int>>> p;
	p.push(make_pair(0,start));

	

	while (!p.empty()) {
		int now = p.top().second;
		int distance = p.top().first;
		p.pop();
		if (now == end) {
			result = d[now];
			break;
		}

		for (int x = 0; x < alist[now].size(); x++) {
			int next = alist[now][x].first;
			int nextDist = distance + alist[now][x].second;

			if (nextDist < d[next]) {
				d[next] = nextDist;
				p.push(make_pair(nextDist, next));
			}


		}
	}
}
int main() {
	cin >> n >> m >> k;
	int ans1, ans2;
	int answer = 0;
	for (int x = 0; x < m; x++) {
		int from, to, weight;
		cin >> from >> to >> weight;
		alist[from].push_back({ to, weight });
	}

	for (int x = 1; x <= n; x++) {
		dijkstra(x,k);
		ans1 = result;
		dijkstra(k, x);
		ans2 = result;
		if (answer < ans1 + ans2) answer = ans1 + ans2;
	}

	cout << answer;
	return 0;
}