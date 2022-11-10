#include <iostream>
#include <queue>
#include <map>
using namespace std;


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int number;
	int input[1000000];

	priority_queue<int, vector<int>, greater<int>> pq;
	cin >> number;
	for (int x = 0; x < number; x++) {
		int value;
		cin >> value;
		input[x] = value;
		pq.push(value);
	}
	map<int, int> temp;
	int cnt = 0;
	while (!pq.empty()) {
		if (!temp.count(pq.top())) {
			temp.insert(make_pair(pq.top(), cnt++));
		}
		pq.pop();
	}

	for (int x = 0; x < number; x++) {
		cout << temp[input[x]] << " ";
	}
	return 0;
}