#include <iostream>
#include <queue>
using namespace std;

priority_queue<long long, vector<long long>, greater<long long>> Q;
long long number, mix;
long long first, second, putQ;
long long result = 0;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> number >> mix;

    for (int x = 0; x < number; x++) {
        int value;
        cin >> value;
        Q.push(value);
    }

    while (mix > 0) {
        first = Q.top();
        Q.pop();
        second = Q.top();
        Q.pop();
        putQ = first + second;
        Q.push(putQ);
        Q.push(putQ);
        mix--;
    }

    for (int x = 0; x < number; x++) {
        result += Q.top();
        Q.pop();
    }

    cout << result;
    return 0;
}