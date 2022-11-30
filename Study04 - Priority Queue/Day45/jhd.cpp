#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int n, cnt;
ll a;
priority_queue<long long> pq;

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> a;
        if( a == 0 ) {
            if(pq.size() == 0)cout << 0 << "\n";
            else {
                int b = pq.top();
                cout << b << "\n";
                pq.pop();
            }
        } else pq.push(a);
    }
}