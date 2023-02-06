#include <string>
#include <vector>
#include <iostream>
using namespace std;

int dp[100001];
int v[100001];
int main() {
    int N, M;
    cin >> N >> M;

    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int x = 1; x <= N; x++) {
       
        cin >> v[x];
        dp[x] = dp[x - 1] + v[x];
    }

    for (int x = 0; x < M; x++) {
        int a, b;
   
        cin >> a >> b;

        cout << dp[b] - dp[a-1] <<"\n";
    }
    return 0;
}