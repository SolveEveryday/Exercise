#include <iostream>
#include <stack>
#include<cstring>
using namespace std;

  int main() {
 	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	char v[51];
	cin >> v;
	stack<char> st;

	int len = strlen(v);
	for (int x = 0; x < len; x++) {
		if (st.empty()) {
			st.push(v[x]);
			continue;
		}

		if (v[x] == ')' && st.top() == '(') {
			st.pop();
		}
		else {
			st.push(v[x]);
		}

	}
	
	cout << st.size();

	return 0;
}