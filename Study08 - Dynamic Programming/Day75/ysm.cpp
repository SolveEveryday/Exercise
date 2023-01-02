#include <iostream>
#include <vector>
using namespace std;

int main() {
	int number;
	cin >> number;
	vector<int> alist(number+1);
	for (int x = 1; x <= number; x++) {
		cin >> alist[x];
	}
	vector<int> result(number+1);
	int max = 0;
	result[0] = 0;
	for (int y = 1; y <= number; y++) {
		for (int x = 0; x < y; x++) {
			if (alist[y] > alist[x] && result[y] < result[x] + 1) {
				result[y] = result[x] + 1;
			}
		}

		if (max < result[y]) max = result[y];
	}

	cout << max;

	return 0;
}