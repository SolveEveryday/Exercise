#include <iostream>
#include <queue>
#include <bits/stdc++.h>

using namespace std;

queue<pair<int, int>> Q;

int findMax() {
	queue<pair<int, int>> copyQ = Q;
	int maxN = 0;

	while (!copyQ.empty()) {
		maxN = max(copyQ.front().first, maxN);
		copyQ.pop();
	}

	return maxN;
}
int main() {
    
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int number;
	cin >> number;
	int N, M;
	
	while (number--) {
		cin >> N >> M;
		int cnt = 0;
		for (int x = 0; x < N; x++) {
			int input;
			cin >> input;
			if (x == M) {
				Q.push(make_pair(input,1));
			}
			else {
				Q.push(make_pair( input,0));
			}
		}
		
		while (true) {
			if (Q.front().first == findMax()) {
				cnt++;
				if (Q.front().second == 1) {
					cout << cnt << '\n';
					while (!Q.empty()) Q.pop();
					break;
				}
				else {
					Q.pop();
				}
			}
			else {
				pair<int, int> save = Q.front();
				Q.pop();
				Q.push(save);
			}

		}
	}
	return 0;

}