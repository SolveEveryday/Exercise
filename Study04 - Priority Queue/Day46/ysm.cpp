#include <iostream>
#include <queue>
using namespace std;

priority_queue<int, vector<int>, greater<int> > q;
queue<int> sum;
int number;
int result = 0;
int first, second;
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

    while (q.size() > 1) {
        first = q.top();
        q.pop();
        second = q.top();
        q.pop();
        result += first + second;
        q.push(first + second);
    }

    cout << result;
    return 0;
}