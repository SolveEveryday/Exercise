#include<bits/stdc++.h>
using namespace std;

int high[500000], answer[500000], n;

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	cin >> n;

	for (int i = 0; i < n; i++) cin >> high[i];
    
	stack<pair<int, int>> stk;
	for (int i = n - 1; i >= 0; i--) {
		while (!stk.empty() && stk.top().first < high[i]) {
			answer[stk.top().second] = i + 1;
			stk.pop();
		}
        // 스택에 높이와 인덱스를 넣는다.
		stk.push({ high[i],i });
	}
	for (int i = 0; i < n; i++) {
		cout << answer[i] << ' ';
	}
	return 0;
}
        