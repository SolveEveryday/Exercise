#include <iostream>
#include <cstring>
#include <stack>
using namespace std;

char v[51];
int len = 0;

void check() {
	stack<char> st;
	for (int x = 0; x < len; x++) {
		if (v[x] == '(') st.push(v[x]);
		if (v[x] == ')') {
			if (st.empty()) {
				cout << "NO" << "\n";
				return;
			}
			if (st.top() == '(') {
				st.pop();
			}
		}
	}

	if (!st.empty()) {
		cout << "NO" << "\n";
		return;
	}
	else cout << "YES" << "\n";
}

int main() {
	  
	int number;
	cin >> number;
	for (int x = 0; x < number; x++) {
		cin >> v;
		len = strlen(v);
		check();
	}

	return 0;
}