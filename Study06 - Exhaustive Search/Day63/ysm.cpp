#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;
int n;
int scv[3];
int dp[66][66][66];
int run(int s, int c, int v)
{
    if (s == 0 && c == 0 && v == 0)
        return 0;
    if (dp[s][c][v] != -1)return dp[s][c][v];
    dp[s][c][v] = 1000000000;
    dp[s][c][v] = min(dp[s][c][v], run(max(0, s - 9), max(0, c - 3), max(0, v - 1)) + 1);
    dp[s][c][v] = min(dp[s][c][v], run(max(0, s - 9), max(0, c - 1), max(0, v - 3)) + 1);
    dp[s][c][v] = min(dp[s][c][v], run(max(0, s - 3), max(0, c - 9), max(0, v - 1)) + 1);
    dp[s][c][v] = min(dp[s][c][v], run(max(0, s - 3), max(0, c - 1), max(0, v - 9)) + 1);
    dp[s][c][v] = min(dp[s][c][v], run(max(0, s - 1), max(0, c - 9), max(0, v - 3)) + 1);
    dp[s][c][v] = min(dp[s][c][v], run(max(0, s - 1), max(0, c - 3), max(0, v - 9)) + 1);
    return dp[s][c][v];
}

int main() {
    memset(dp, -1, sizeof(dp));
    cin >> n;
    for (int i = 0; i < n; i++)
        cin >> scv[i];
    cout << run(scv[0], scv[1], scv[2]);
    return 0;
}
