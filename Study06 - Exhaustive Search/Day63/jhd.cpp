#include <bits/stdc++.h> 
using namespace std;
const int INF = 987654321;
int dp[64][64][64], a[3], n, visited[64][64][64]; 
// 3방을 치는 경우의 수
int _a[6][3] = {
	{9, 3, 1}, 
	{9, 1, 3}, 
	{3, 1, 9}, 
	{3, 9, 1}, 
	{1, 3, 9}, 
	{1, 9, 3}
};
struct A{
    int a, b, c; 
}; 
queue<A>q; 
int solve(int a, int b, int c){
    // 방문처리
    visited[a][b][c] = 1; 
    // 큐에 넣는 걸로 시작
    q.push({a, b, c}); 
    while(q.size()){
        int a = q.front().a; 
        int b = q.front().b; 
        int c = q.front().c; 
        q.pop();
        if(visited[0][0][0]) break;
        for(int i = 0; i < 6; i++){
            int na = max(0, a - _a[i][0]);
            int nb = max(0, b - _a[i][1]); 
            int nc = max(0, c - _a[i][2]); 
            if(visited[na][nb][nc]) continue;
            visited[na][nb][nc] = visited[a][b][c] + 1;  
            q.push({na, nb, nc}); 
        }
    }
    return visited[0][0][0] - 1;   
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
	cin >> n; 
	for(int i = 0; i < n; i++) cin >> a[i]; 
	cout << solve(a[0], a[1], a[2]) << "\n"; 
    return 0;
}
1. 방문처리를 해줍니다.
2. 받아온 수들을 뽑아 옵니다.
3. 그리고 가장 상단의 경우를 뽑아냅니다.
4. 0,0,0을 방문했으면 break합니다.
5. 6가지 경우를 모두 검사합니다.
6. 인덱스를 활용해서 0 미만의 수가 되는 것을 방지하고
7. 지금 방문한 정점에 +1을 해서 다음 정점을 q에 push
8. 0,0,0이 나올 때 까지 반복합니다. 
9. 결과를 출력합니다. 