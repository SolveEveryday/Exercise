#include<iostream>
#include<string>
#include<algorithm>
using namespace std;

string str;
int len;
int num[27];
string middle;
string result;
void check() {
	if (len % 2 == 0) {
		for (int x = 0; x < 27; x++) {
			if (num[x] % 2 != 0) {
				cout << "I'm Sorry Hansoo";
				return;
			}
		}
	}

	int cnt = 0;
	for (int x = 0; x < 27; x++) {
		if (num[x] == 0) continue;
		if (num[x] % 2 != 0) {
			middle = (char)(x + 'A');
			num[x]--;
			cnt++;
		}

		if (cnt > 1) {
			cout << "I'm Sorry Hansoo";
			return;
		}
	}

	for (int x = 0; x < 27; x++) {
		if (num[x] == 0) continue;
		
		for (int y = 0; y < num[x] / 2; y++) {
			result += (char)(x + 'A');
		}
		num[x] = num[x] / 2;
	}

	string tmp = result;
	reverse(tmp.begin(), tmp.end());
	if (middle.length() > 0) result += middle;
	result += tmp;
	cout << result;
	return;
}
int main() {
	cin >> str;
	len = str.length();
	for (int x = 0; x < len; x++) {
		num[str[x] - 'A']++;
	}

	check();
	return 0;
}