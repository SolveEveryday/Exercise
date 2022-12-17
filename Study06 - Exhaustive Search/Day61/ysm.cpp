#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;
int N, arr[10];
vector<long long>v;
void func(int level, int startIdx, int last) {
    if (level == last) {
        long long ans = 0;
        int p = 0;
        for (int idx = 0; idx < 10; idx++) {
            if (arr[idx]) {
                ans += idx * pow(10, p);
                p += 1;
            }
        }
        v.push_back(ans);
        return;
    }
    for (int x = startIdx; x < 10; x++) {
        if (arr[x]) continue;
        arr[x] = 1;
        func(level + 1, x, last);
        arr[x] = 0;
    }
}
int main() {
    cin >> N;
    if (N > 1023) {
        cout << -1;
        return 0;
    }
    for (int x = 1; x <= 10; x++) {
        func(0, 0, x);
    }
    sort(v.begin(), v.end());
    cout << v[N - 1];
}