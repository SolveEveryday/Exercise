#include <iostream>
#include <vector>
using namespace std;


int main() {
    
    int amount, number;
    cin >> amount >> number;
    vector<int> v[500000];
    int cnt = 0;
    for (int x = 0; x < amount; x++) {
        int line, n;
        cin >> line >> n;
        
        if (v[line].empty()) {
            v[line].push_back(n);
            cnt++;
            continue;
        }

        if (v[line].back() < n ) {
            v[line].push_back(n);
            cnt++;
            continue;
        }
        if (v[line].back() > n) {
            while (!v[line].empty() && v[line].back() > n) {
                v[line].pop_back();
                cnt++;
            }

           
            if (v[line].empty() || v[line].back() < n) {
                v[line].push_back(n);
                cnt++;
                continue;
            }

            if (v[line].back() == n) {
                continue;
            }
        }
    }

    cout << cnt;
    return 0;
}