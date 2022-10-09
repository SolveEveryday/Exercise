#include <iostream>
#include <string>
using namespace std;

int main(void) {
	int n;
	cin >> n;

	int count = n;
	while (n > 0) {
		string input;
		cin >> input;

		bool alphabet[26] = { false };
		for (int i = 0; i < input.length(); i++) {
			int idx = input[i] - 'a';
			if (!alphabet[idx]) {
				alphabet[idx] = true;
			}

			else if (alphabet[idx] && (input[i] != input[i - 1])) {
				count -= 1;
				break;
			}
		}
		n--;
	}
	cout << count;

	return 0;
}

