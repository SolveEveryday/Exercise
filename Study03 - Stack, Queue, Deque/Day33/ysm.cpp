#include <iostream>
#include <deque>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int size, cnt;
	cin >> size >> cnt;
	deque<int> Q;

	for (int x = size; x >= 1; x--) {
		Q.push_front(x);
	}
	int result = 0;
	int indx;
	while (cnt--) {
		int input;
		cin >> input;
		for (int x = 0; x < Q.size(); x++) {
			if (Q[x] == input) {
				indx = x;
				break;
			}
		}

		if ( indx <= (Q.size()/2)) {
			while (true) {
				if (input == Q.front()) {
					Q.pop_front();
					break;
				}

				Q.push_back(Q.front());
				Q.pop_front();
				result++;
			}
			
		}
		else {
			while (true) {
				if (input == Q.front()) {
					Q.pop_front();
					break;
				}
				Q.push_front(Q.back());
				Q.pop_back();
				result++;
			}
		}
	}

	cout << result;
	return 0;

}