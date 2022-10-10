#include <iostream>
#include <cmath>
using namespace std;

int main() {
    int w, h, n, sum = 0;
    cin >> w >> h >> n;
    int d, o, * a = new int[n + 1];
    for (int i = 0; i <= n; i++) {
        cin >> d >> o;
        switch (d) {
        case 1: a[i] = o; break;
        case 2: a[i] = 2 * w + h - o; break;
        case 3: a[i] = 2 * (w + h) - o; break;
        case 4: a[i] = w + o; break;
        }
    }
    for (int i = 0; i < n; i++) {
        int tmp = abs(a[i] - a[n]);
        sum += (tmp < (w + h)) ? tmp : 2 * (w + h) - tmp;
    }
    cout << sum;
}


