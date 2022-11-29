#include <iostream>
#include <queue>
using namespace std;

priority_queue<int, vector<int>, greater<int> > q;
queue<int> sum;
int number;
int result = 0;
int tmp = 0;
int plusA = 0;

int main() {


    cin >> number;
    for (int x = 0; x < number; x++) {
        int value;
        cin >> value;
        q.push(value);
    }

    if (q.size() == 1) {
        cout << result;
        return 0;
    }

    while (!q.empty()) {
        if (sum.empty()) {
            tmp = q.top();
            q.pop();
            result = tmp + q.top();
            q.pop();
            sum.push(result);
            continue;
        }

        plusA = sum.back() + q.top();
        sum.push(plusA);
        result += plusA;
        q.pop();
    }

    cout << result;
    return 0;
}