#include <iostream>
#include <set>

using namespace std;

set<int> s;
set<int>::iterator check;
set<int>::iterator t;

int main(void) {
	int A, B;
	int setA;
	int setB;
	cin >> A >> B;

	for (int x = 0; x < A; x++) {
		cin >> setA;
		s.insert(setA);
	}

	for (int x = 0; x < B; x++) {
		cin >> setB;

		check = s.find(setB);

		if (check == s.end()) {
			continue;
		}
		else {
			s.erase(check);
		}
	}

	cout << s.size() << "\n";

	for (t = s.begin(); t != s.end(); t++) {
		cout << *t << " ";
	}

	cout << "\n";

	return 0;
}