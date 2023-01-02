#include <bits/stdc++.h>
using namespace std;
int N, dasom;
priority_queue<int> pq;
int main() {
    
    cin >> N >> dasom;

    // Dasom은 이미 위에서 받음 
    for(int i = 0; i < N-1; i++) {
        int vote;
        cin >> vote;
        pq.push(vote);
    }

    // 이제 Q에 있는 값들의 최대값이 dasom을 넘을때 끝난다. 
    // 그리고 dasom이가 하나 가져갈 때마다 cnt를 올린다.
    int cnt = 0;

    while(N != 1) {
        if(dasom <= pq.top()) {
            int max = pq.top();
            pq.pop();
            max--;
            dasom++;
            pq.push(max);

            cnt++;
        }
        else {
            break;
        }
    }
    cout << cnt;
    return 0;
}