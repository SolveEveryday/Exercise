#include <iostream>
#include <algorithm>
using namespace std;


int main() {
	
	int number;
	cin >> number;
	int array[100000];
	for (int x = 0; x < number; x++) {
		cin >> array[x];
	}

	int first = 0;
	int second = number - 1;
	int result = 200000000;

	while (first < second) {
		int sum = array[first] + array[second];

		if (abs(sum) < abs(result)) result = sum;

		if (sum == 0) break;
		if (sum < 0) first++;
		if (sum > 0) second--;
		
	}

	cout << result;
	return 0;
}