#include<iostream>
#include<vector>
using namespace std;


int main() {
	ios_base::sync_with_stdio(0);
	long long testN;
	long long stockN;

	cin >> testN;
	while (testN) {
		cin >> stockN;
		vector<long long> v(stockN);

		long long result = 0;
		for (long long x = 0; x < stockN; x++) {
			cin >> v[x];
		}
		long long max = -1;

		for (long long x = stockN -1; x >= 0; x--) {
			if (v[x] > max ) {
				max = v[x];
				continue;
			}
			result += (max - v[x]);
		}
		cout << result<<"\n";
		testN--;
	}
	return 0;
}