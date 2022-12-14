#include <iostream>
#include <queue>
using namespace std;

int numbers[9];
priority_queue <int, vector<int>, greater<int>> Q;

int main() {

    for (int x = 0; x < 9; x++) {
        cin >> numbers[x];
    }

    int flag = 0;
    int first = 0;
    int second = 0;
    for (int z = 0; z < 8; z++) {
        for (int y = z + 1; y < 9; y++) {
            int sum = 0;
            for (int x = 0; x < 9; x++) {
                if (x != z && x != y) {
                    sum += numbers[x];
                }
            }
            if (sum == 100) {
                first = z;
                second = y;
                flag = 1;
                break;
            }
        }
        if (flag) break;
    }

    for (int x = 0; x < 9; x++) {
        if (x != first && x != second) {
            Q.push(numbers[x]);
        }
    }

    for (int x = 0; x < 7; x++) {
        cout << Q.top() << "\n";
        Q.pop();
    }

    return 0;

}