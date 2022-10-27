#include <iostream>
#include <queue>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	priority_queue<int, vector<int>, greater<int>> pq;
	int amount;
	cin >> amount;
	
	for (int x = 0; x < amount; x++) {
		int value;
		cin >> value;
		pq.push(value);

	}

	int now = 1;
	long long cnt = 0;
	while (!pq.empty()) {
		int pqValue = pq.top(); pq.pop();
		if (pqValue >= now)
		{
			cnt += pqValue - now;
			now++;
		}
	}
	cout << cnt;
	return 0;
}