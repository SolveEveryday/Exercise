#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    stack<char> st;
    string s;
    cin >> s;

    int answer = 0;
    int mul = 1;

    for (int i = 0; i <= s.length(); i++) {
        if (s[i] == '(') {
            mul *= 2;
            st.push('(');
        } else if (s[i] == '[') {
            mul *= 3;
            st.push('[');
        } else if (s[i] == ']') {
            if (st.empty() || st.top() != '[') {
                cout << 0;
                return 0;
            }

            if (s[i-1] == '[') answer += mul;
            st.pop();
            mul /= 3;
        } else if (s[i] == ')') {
            if (st.empty() || st.top() != '(') {
                cout << 0;
                return 0;
            }

            if (s[i-1] == '(') answer += mul;
            st.pop();
            mul /= 2;
        }
    }

    if (st.empty()) cout << answer;
    else cout << 0;

    return 0;
}