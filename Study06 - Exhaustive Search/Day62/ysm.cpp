#include <cstdio>
#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
string a[50];
string w[8] = {
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW"
};
string b[8] = {
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB"
};
int w_cnt(int x, int y) {
    int cnt = 0;
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (a[x + i][y + j] != w[i][j]) {
                cnt++;
            }
        }
    }
    return cnt;
}
int b_cnt(int x, int y) {
    int cnt = 0;
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (a[x + i][y + j] != b[i][j]) {
                cnt++;
            }
        }
    }
    return cnt;
}
int main() {
    int n, m;
    scanf("%d %d", &n, &m);
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    int result = 65;
    for (int i = 0; i + 8 <= n; i++) {
        for (int j = 0; j + 8 <= m; j++) {
            result = min(result, min(w_cnt(i, j), b_cnt(i, j)));
        }
    }
    printf("%d", result);
    return 0;
}