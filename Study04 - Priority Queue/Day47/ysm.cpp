#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

priority_queue<pair<int,int>, vector<pair<int, int>>, greater<pair<int,int>>> Q;
int number;
int main() {

    cin >> number;
    for (int x = 0; x < number; x++) {
        int value;
        cin >> value;
        if (value == 0) {
            if (Q.empty()) {
                cout << "0" << "\n";
                continue;
            }
            cout << Q.top().second;
            Q.pop();
            continue;
        }

        Q.push(make_pair(abs(value),value));
    }

    return 0;
}