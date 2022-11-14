#include<bits/stdc++.h>
using namespace std;
int testcnt;
int len;
int inputPin;
int m;


// 1. queue 자료구조를 이용합니다.
// 2. 가장 큰 중요도를 매번 비교할 수 없기 때문에 우선순위 큐를 이용하여 가장 높은 중요도가 queue의 맨 앞에 오도록합니다.
// 3. 큐에는 인덱스와 중요도를 받고 우선순위 큐에는 중요도만 입력받습니다.
// 4. queue를 순회를 돌며 우선순위 큐의 가장 앞 수와 비교합니다.
// 5. 가장 큰 중요도와 비교하여 작으면 뒤로 보내고 그렇지 않으면 두 큐 모두에서 가장 앞의 중요도 문서를 출력합니다.(pop으로 제거)
// 6. 출력이 되었으므로 출력 카운트를 올려줍니다.
// 7. 그리고 확인하고 싶은 문서의 인덱스와 현재 출력되는 인덱스가 같으면 반복을 멈추고 출력횟수를 콘솔에 표시합니다.
int main() {
    cin >> testcnt;
    for(int i = 0; i < testcnt; i++) {
        // 중요도와 인덱스를 받을 queue를 선언합니다.
        queue<pair<int,int>> q;

        // 중요도가 정리된 결과 기준을 만듭니다.
        priority_queue<int> importans;

        // 매 케이스마다 출력 횟수를 초기화 합니다.
        int printCnt = 0;

        cin >> len >> inputPin;
        for( int j = 0; j < len; j++) {
            cin >> m;
            q.push({j,m});
            importans.push(m);
        }
        
        // 이제 무한 반복을 돌며 우선순위의 맨 앞 수와 중요도를 비교하며 작업을 반복합니다.
        while(!q.empty()){
            int index = q.front().first;
            int important = q.front().second;

            if(importans.top() > important){
                q.push(q.front());
                q.pop();
            }else {
                q.pop();
                importans.pop();
                printCnt++;
                // 출력 차례가 되면 해당 인덱스와 기대했던 인덱스를 비교합니다.
                if(inputPin == index) {
                    cout << "printCnt :: " << printCnt << "\n";
                    break;
                }
            }
        }
    }
  
    
  
  return 0;
}

