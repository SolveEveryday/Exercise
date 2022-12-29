#include<bits/stdc++.h>
using namespace std;
int DP[1001][3];
int N;
int main() {
    cin >> N;
    int R,G,B;
    DP[0][0] = 0;
    DP[0][1] = 0;
    DP[0][2] = 0;

    for (int i= 1 ; i <= N; i++) {
        cin >> R >> G >> B;
        DP[i][0] = min(DP[i-1][1],DP[i-1][2]) + R;
        DP[i][1] = min(DP[i-1][0],DP[i-1][2]) + G;
        DP[i][2] = min(DP[i-1][0],DP[i-1][1]) + B;     
    }

    cout << min(DP[N][2],min(DP[N][1],DP[N][0]));
}