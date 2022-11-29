#include <iostream>
#include <queue>
using namespace std;

int main() {
    priority_queue<int> Q;
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int number;
    cin >> number;
    for (int x = 0; x < number; x++) {
        int value;
        cin >> value;
        if (value > 0) {
            Q.push(value);
        }
        else {
            
            if (Q.empty()) {
                cout << "0"<<"\n";
            }
            else {
                cout << Q.top()<<"\n";
                Q.pop();
            }
        }
    }
    return 0;
}