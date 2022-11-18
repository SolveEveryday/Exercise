#include <iostream>
#include <deque>
using namespace std;

int main() {
	
	deque<int> Q;
	int number, idx, m;
	cin >> number >> idx >> m;

	for (int x = 1; x <= number; x++) {
		Q.push_back(x);
	}
	int cnt = 0;
	int flagFront = 1;
	int flagBack = 0;

	while (!Q.empty()) {

		if (flagFront) {
			for (int x = 0; x < idx - 1; x++) {
				Q.push_back(Q.front());
				Q.pop_front();
			}
			cnt++;
			cout << Q.front() << "\n";
			Q.pop_front();
		}

		if (flagBack) {
			for (int x = 0; x < idx - 1; x++) {

				Q.push_front(Q.back());
				Q.pop_back();
			}
			cout << Q.back() << "\n";
			Q.pop_back();
			cnt++;
		}

		if (cnt == m) {

			if (flagFront && cnt > 0) {
				flagFront = 0;
				flagBack = 1;
				cnt = 0;
			} 

			if (flagBack && cnt > 0) {
				flagBack = 0;
				flagFront = 1;
				cnt = 0;
			}
			
		}
	}
	return 0;
}