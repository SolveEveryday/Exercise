#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	int N;
	cin >> N;
	vector<int> v((N * 2)+1,0);
	for (int x = 1; x <= N; x++) {
		int a;
		cin >> a;
		v[x] = a;
		v[x + N] = a;
	}

	for (int x = 1; x <= 2*N; x++) {
		v[x] = v[x] + v[x - 1];
	}

	int answer = 0;
	for (int y = 1; y <= N; y++) {
		for (int x = y + 1; x <= N; x++) {
			int a = v[x] - v[y];
			int b = v[N + y] - v[x];
			answer = max(answer,min( a, b));
		}
	}

	cout << answer;
	return 0;
}