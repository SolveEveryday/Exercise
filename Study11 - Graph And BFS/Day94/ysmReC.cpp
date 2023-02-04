#include <iostream>
#include <queue>
using namespace std;

int n, k;
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> q;

int used[100001];
int timeM, num;
void check() {
	q.push(make_pair(0,n));
	used[n] = 1;
	while (!q.empty()) {
		timeM = q.top().first;
		num = q.top().second;
		q.pop();

		if (num == k) {
			return;
		}

		if (num * 2 < 100001 && used[num*2] == 0) {
			q.push(make_pair(timeM,num * 2));
			used[num * 2] = 1;
		}

		if (used[num - 1] == 0 && num-1>=0) {
			q.push(make_pair(timeM+1, num - 1));
			used[num - 1] = 1;
		}
		if (num + 1 < 100001 && used[num + 1] == 0) {
			q.push(make_pair(timeM+1, num + 1));
			used[num + 1] = 1;
		}
		
	}
}
int main() {
	cin >> n >> k;

	check();
	cout << timeM;
	return 0;
   
}