#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); 
    cout.tie(0);

    int total;
    int lastNumber;
    
    cin >> total;
    vector<int> v;

    for (int x = 0; x < 8; x++) {
        int value;
        cin >> value;
        v.push_back(value);
    }
    cin >> lastNumber;

    int nowNum = total / 2;
    while (true) {
        int idx = 0;
        int size = total / nowNum;

        for (int x = 0; x < nowNum; x++) {
            sort(v.begin() + idx, v.begin() + idx + size);
            idx += size;
        }

        if (nowNum == lastNumber) {
            for (int x = 0; x < total; x++) {
                cout << v[x] << " ";
            }
            break;
        }

        nowNum /= 2;
    }
    return 0;
}
