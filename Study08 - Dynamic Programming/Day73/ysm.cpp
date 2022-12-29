#include <iostream>
 
using namespace std;
 
int dp[1010];
int map[1010];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    
    int maxv = 1;
    
    int N; cin >> N;
    fill(dp, dp+N, 1);
    for(int i=0; i<N; i++) cin >> map[i];
    
    for(int j=0; j<N; j++) {
        for(int i=0; i<j; i++) {
            
            if(map[j] > map[i]) {
                dp[j] = max(dp[j], dp[i]+1);
                maxv = max(maxv, dp[j]);
            }
        }
    }
    
    cout << maxv << '\n';
    return 0;
}