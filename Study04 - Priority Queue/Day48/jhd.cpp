#include<bits/stdc++.h>
using namespace std;
long long n , m, a, b, sum;
typedef long long ll;
priority_queue< long long , vector<long long>, greater<long long>> pq;

int main() {
    cin >> n >> m;

    for ( int i = 0 ; i < n; i++ ) {
        cin >> a;
        pq.push(a);
    }

    for ( int i = 0 ; i < m; i++ ) {
        a = pq.top();
        pq.pop();
        b = pq.top();
        pq.pop();

        pq.push(a+b);
        pq.push(a+b);
    }

    for(int i = 0 ; i < n; i++) {
        sum += pq.top();
        pq.pop();
    }

    cout << sum;
}