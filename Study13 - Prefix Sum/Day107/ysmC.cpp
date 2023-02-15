
#include <iostream>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M;
	cin >> N >> M;
	vector<vector<int>> inputArray(N+1, vector<int>(N+1, 0));
	vector<vector<int>> saveSum(N+1,vector<int>(N+1,0));

	for (int y = 1; y <= N; y++) {
		for (int x = 1; x <= N; x++) {
			cin >> inputArray[y][x];
			saveSum[y][x] = inputArray[y][x] + saveSum[y - 1][x] + saveSum[y][x - 1] - saveSum[y - 1][x - 1];
		}
	}


	int startY, startX, endY, endX;
	int result;
	while (M > 0) {
		cin >> startY >> startX >> endY >> endX;

		result = saveSum[endY][endX] - saveSum[endY][startX-1] - saveSum[startY-1][endX] + saveSum[startY-1][startX-1];
		cout << result << "\n";
		M--;
	}
	
	return 0;

}