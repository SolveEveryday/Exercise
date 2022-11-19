#include<bits/stdc++.h>
using namespace std;
int N,M,K,cnt;
bool flag;
deque<int> dq;

int main() {
    cin >> N >> K >> M;
    flag = true;
    cnt = 0;
    for (int i = 1; i <= N; i++) dq.push_back(i);
    
    for (int q = 0; q < N; q++){

        if( cnt == M ) {
            flag = !flag;
            cnt = 0;
        }
        if (flag) { //앞을 빼서 뒤에 넣는다.
			for (int i = 0; i < K - 1; i++) {
				dq.push_back(dq.front());
				dq.pop_front();
			}
			cout << dq.front() << '\n';
			dq.pop_front();
		
		}else{ //뒤를 빼서 앞에 넣는다.
			for (int i = 0; i < K - 1; i++) {
				dq.push_front(dq.back());
				dq.pop_back();
			}
			cout << dq.back() << '\n';
			dq.pop_back();
		}
        cnt++;
    }
    
}

