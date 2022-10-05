#include <iostream>
#include <vector>
using namespace std;

int main() {

	char input;
	vector<int> alphabet(26);
	while (cin >> input) {
		if (input >= 'a' && input <= 'z') {
			alphabet[input - 'a']++;
		}
	}

	int max = 0;
	for (int x = 0; x < 26; x++) {
		if (max < alphabet[x]) {
			max = alphabet[x];
		}
	}

	for (int x = 0; x < 26; x++) {
		if (max == alphabet[x]) {
			cout << (char)(x + 'a');
		}
	}

	return 0;
}
