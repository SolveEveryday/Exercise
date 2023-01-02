#include<iostream>
#include<queue>
using namespace std;

int num;
int mine;
priority_queue<int> q;
int cnt = 0;

void check() {
	if (num == 1) return;
	for (int x = 0; x < num - 1; x++) {
		int value;
		cin >> value;
		q.push(value);
	}
	
	while (1) {
		if (q.top() < mine) break;
		if (q.top() >= mine) {
			int number = q.top() - 1;
			cnt++;
			mine++;
			q.pop();
			q.push(number);
		}

	}
}

int main() {

	cin >> num;
	cin >> mine;
	check();

	cout << cnt;
	return 0;
}