#include<iostream>
#include<vector>
#include<algorithm>
#include <string>
#include <cmath>
using namespace std;

int amount;
vector<string> v(amount);
int used[26];
int cnt = 0;
int main() {
	cin >> amount;
	for (int x = 0; x < amount; x++) {
		string value;
		cin >> value;
		v.push_back(value);
		int idx = v[x].size() - 1;
		int len = v[x].size();
		for (int y = 0; y < len ; y++) {
			used[v[x][y] - 'A'] += pow(10, idx);
			idx--;
		}
	}

	sort(used, used+26);
	int result = 0;
	int num = 9;
	for (int x = 25; x >=0; x--) {
		if (used[x] == 0) break;
		result += num * used[x];
		num--;
	}

	cout << result;

	return 0;
}
