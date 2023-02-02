#include <iostream>
using namespace std;


int main() {
	int T, N, M,a,b;
	cin >> T;
	while (T > 0) {
		cin >> N >> M;
		for (int x = 0; x < M; x++) {
			cin >> a >> b;
		}
		cout << N - 1 << "\n";
		T--;
	}
	return 0;
   
}