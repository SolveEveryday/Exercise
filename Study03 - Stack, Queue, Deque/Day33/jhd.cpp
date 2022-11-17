#include<bits/stdc++.h>
using namespace std;
int n, m, target, cnt;
queue<int> targets;
deque<int> DQ;
// deck initialize
void initializeTargets(){
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        cin >> target;
        targets.push(target);
        
    }
    for (int i = 1; i <= n; i++) {
        DQ.push_back(i);
    }

}
// 2번 연산
void two(){
    DQ.push_back(DQ.front());
    DQ.pop_front();
}

//3번 연산 
void three(){

    DQ.push_front(DQ.back());
    DQ.pop_back();
}
// 결과 출력 메서드
void caculateResult(){

    while(true) {
        int targetIndex = find(DQ.begin(), DQ.end(),targets.front()) - DQ.begin();
        int howFar = DQ.size() - targetIndex;

        if(targets.empty()) break; 
        if(targetIndex == 0) {
            targets.pop();
            DQ.pop_front();
            continue;
        }
        if(howFar < targetIndex) {
            three();
            cnt++;
        }else{
            two();
            cnt++;
        }
    }
    
    cout << cnt;
}

int main() {

    initializeTargets();
    caculateResult();

    return 0;
}

