#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int n;
int wine[10001];
int dp[10001];
int check() {
	
	dp[1] = wine[1];
	dp[2] = wine[1] + wine[2];

	for (int x = 3; x <= n; x++) {
		dp[x] = max(dp[x - 3] + wine[x - 1] + wine[x], max(dp[x - 2] + wine[x], dp[x - 1]));
	}

	return dp[n];
}
int main() {
	
	cin >> n;
	for (int x = 1; x <= n; x++) {
		cin >> wine[x];

	}

	cout << check();
	return 0;
}