#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
	int N, K, B;
	cin >> N >> K >> B;
	vector<int> light(N+1,0);
	for (int x = 0; x < B; x++) {
		int a;
		cin >> a;
		light[a]++;
	}

	int cnt = 0;
	for (int x = 1; x <= K; x++) {
		if (light[x] != 0) cnt++;
	}
	
	int min = 9999;
	for (int end = K+1; end <= N; end++) {
		if (light[end] != 0) cnt++;
		if (light[end - K] != 0) cnt--;
		if (min > cnt) min = cnt;
	}

	cout << min;
}