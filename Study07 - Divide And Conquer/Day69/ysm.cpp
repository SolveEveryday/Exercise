#include <iostream>
#include <vector>
using namespace std;

int number;
int num[3] = { 0 };
int v[2200][2200];;

int check(int size, int x, int y) {
	int getout = 0;
	int firstN = v[y][x];
	for (int k = y; k < y + size; k++) {
		for (int m = x; m < x + size; m++) {
			if (v[k][m] != firstN) {
				return 0;
			}
		}
	}
	num[firstN + 1]++;
	return 1;
}

void run(int size, int x, int y) {
	
	if (!check(size, x, y)) {
		for (int k = 0; k < 3; k++) {
			for (int m = 0; m < 3; m++) {
				run(size / 3, x + size / 3 * k, y + size / 3 * m);
			}
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	
	cin >> number;
	

	for (int y = 0; y < number; y++) {
		for (int x = 0; x < number; x++) {
			cin >> v[y][x];
		}
	}

	run(number, 0, 0);


	cout << num[0] << "\n";
	cout << num[1] << "\n";
	cout << num[2] << "\n";
	

	return 0;
}