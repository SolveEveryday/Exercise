#include <iostream>
#include <vector>
#include <string>
using namespace std;

int result[1025][1025];

int main() {
	
	int N, M;
	cin >> N >> M;
	for (int y = 1; y <= N; y++) {
		for (int x = 1; x <= N; x++) {
			int a;
			cin >> a;
			result[y][x] = a + result[y - 1][x] + result[y][x - 1] - result[y - 1][x - 1];
		}
	}

	for (int x = 0; x < M; x++) {
		int x1, y1, x2, y2;
		cin >> y1 >> x1 >> y2 >> x2;
		cout << result[y2][x2] - result[y2][x1 - 1] - result[y1 - 1][x2] + result[y1-1][x1-1] <<"\n";
	}
	return 0;
}