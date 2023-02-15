#include <iostream>
#include <algorithm>
using namespace std;
int arr[100001], ans = 0;
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int n; cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		arr[i + n] = arr[i];
	}
	for (int i = 1; i < 2 * n; i++) arr[i] += arr[i - 1];
	for (int i = n; i < 2 * n; i++) {
		for (int j = i - n + 1; j < n; j++) {
			ans = max(ans, min(arr[i] - arr[j], arr[n + j] - arr[i]));
		}
	}
	cout << ans;
	return 0;
}