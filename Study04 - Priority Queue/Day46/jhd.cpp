#include<bits/stdc++.h>
using namespace std;   
typedef long long ll;     
int a[100004], b, c, psum[100004], n ,m, sum;
priority_queue<int,vector<int>, greater<int>> pq;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;

    if (n == 1) {
        cout << 0 << '\n';
        return 0;
    }

    for(int i = 0 ; i < n ; i++) {
        cin >> m;
        pq.push(m);
    }

   while ( pq.size() > 1) {
        b = pq.top();
        pq.pop();
        c = pq.top();
        pq.pop();
        sum += b + c;
        pq.push(b + c);
    }

    cout << sum;
	return 0;
}