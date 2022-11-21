#include <stack>
#include <iostream>
using namespace std;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int number;
    cin >> number;

    stack<pair<int, int>> st;

    for (int x = 1; x <= number; x++) {
        int tower;
        cin >> tower;

        while (!st.empty()) {
            if (st.top().second > tower) {
                cout << st.top().first << " ";
                break;
            }

            st.pop();
        }

        if (st.empty()) {
            cout << '0' << " ";
        }

        st.push(make_pair(x, tower));
    }

    return 0;
}