#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstring>
using namespace std;
const int INF = 987654321;
int N, E, v1, v2, res = INF;
int sToV1, sToV2, V1ToV2, V1ToN, V2ToN;
vector<pair<int, int>> v[801]; 
int dist[801];

void dijk(int start)
{
	for (int i = 0; i <= N; i++) dist[i] = INF;
	dist[start] = 0;
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> q;
	q.push({ 0,start }); 
	while (!q.empty()) {
		int cur = q.top().second;
		int curDist = q.top().first;
		q.pop();
		for (int i = 0; i < v[cur].size(); i++) {
			int next = v[cur][i].first;
			int nextDist = v[cur][i].second;
			if (dist[next] > curDist + nextDist) {
				dist[next] = curDist + nextDist;
				q.push({ dist[next],next });
			}
		}
	}
}

int main()
{
	cin >> N >> E;
	while (E--) {
		int a, b, c;
		cin >> a >> b >> c;
		v[a].push_back({ b,c });
		v[b].push_back({ a,c });
	}
	cin >> v1 >> v2;

	dijk(1);
	sToV1 = dist[v1];
	sToV2 = dist[v2];

	dijk(v1);
	V1ToV2 = dist[v2];
	V1ToN = dist[N];

	dijk(v2);
	V2ToN = dist[N];


	res = min(res, sToV1 + V1ToV2 + V2ToN);
	res = min(res, sToV2 + V1ToV2 + V1ToN);
	if (V1ToV2 == INF || res == INF) cout << -1;
	else cout << res;
}