#include<bits/stdc++.h>
using namespace std;
int n,a;
priority_queue<pair<int,int>, vector<pair<int,int>>,greater<pair<int,int>>> pq;
// 절대값, 원본값
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n;

    for (int i = 0 ; i < n ; i++) {
        cin >> a;
        if( a == 0 ){
            if(pq.size() == 0) {
                cout << 0 << "\n";
                continue;
            } 
            cout << pq.top().second << "\n";
            pq.pop();
            continue;
        }
        pq.push(make_pair(abs(a),a));
    }
}