#include <iostream>
#include <stack>
#include<cstring>
using namespace std;

  int main() {
 	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	stack<char> st;
	char v[100001];
	int result = 0;
	cin >> v;
	int len = strlen(v);
	for (int x = 0; x < len; x++) {
		if (v[x] == '(') st.push(v[x]);
		if (v[x] == ')') {
			if (v[x - 1] == '(') {
				st.pop();
				result += st.size();
			}
			else {
				st.pop();
				result++;
			}

		}
	}

	cout << result;
	return 0;
}