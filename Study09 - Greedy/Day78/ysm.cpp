#include<iostream>
using namespace std;

int num;
int minR = 9999;

int k, m;

int check() {
	
	if (num % 3 == 0) {
		minR = num / 3;
	}
	if (num % 5 == 0) {
		minR = num / 5;
	}
	int a = num / 5;
	while (a) {
		k = num - (5*a);

		if (k % 3 == 0 && k != 0) {
			m = k / 3;
			int result = m + a;
			if (minR > result) {
				minR = result;
			}
		}
		a--;
	}

	if (minR == 9999) minR = -1;
	return minR;
}
int main() {
	
	cin >> num;

	cout << check();
	return 0;
}