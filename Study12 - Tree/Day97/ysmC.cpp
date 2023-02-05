#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;


int main() {
	int fileN;
	cin >> fileN;
	vector<int> num[101];
	int t = 0;
	for (int x = 0; x < fileN; x++) {
		while (1) {
			int a;
			cin >> a;
			if (a == -1) break;
			num[x].push_back(a);
		}
	}

	sort(num, num + fileN);

	int answer = 0;
	for (int x = 1; x < fileN; x++) {
		int minSize = min(num[x - 1].size(), num[x].size());
		int k = 0;
		while (minSize > k && num[x - 1][k] == num[x][k]) k++;
		answer = max(answer, k + 1);
	}

	cout << answer << "\n";
	return 0;
   
}