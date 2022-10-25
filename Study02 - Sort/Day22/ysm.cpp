#include <iostream>
#include <vector>
#include <queue>
using namespace std;
using pii = pair<int, int>;

int main() {
	int amount;
	cin >> amount;
	priority_queue<pii, vector<pii>, greater<pii>> pq;

	for (int x = 0; x < amount; x++) {
		int start, end;
		cin >> start >> end;
		pq.push(make_pair(end, start));
	}
	int cur_time = 0;
	int cnt = 0;
	while (!pq.empty()) {
		auto cur = pq.top(); pq.pop();
		int cur_start = cur.second;
		int cur_end = cur.first;
		if (cur_start < cur_time) continue;
		cur_time = cur_end;
		cnt++;
	}

	cout << cnt;

	return 0;
}