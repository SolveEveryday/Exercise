#include <iostream>
#include <queue>
using namespace std;
 
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
 
    int number;
    cin >> number;
 
    priority_queue<int, vector<int>, greater<int>> pq;
    for (int y = 0; y < number; y++) {
        for (int x = 0; x < number; x++) {
            int input;
            cin >> input;
            pq.push(input);
            if (pq.size() > number) {
                pq.pop();
            }
        }
    }
 
    cout << pq.top();
}
