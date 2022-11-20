#include <bits/stdc++.h>
using namespace std;
deque<int> progre, speedds;
vector<int> answer;
int cnt;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    for( auto a : progresses) progre.push_back(a);
    for( auto a : speeds) speedds.push_back(a);
    while(1) {
        cnt =0;
        if(progre.empty()) break;
        if(progre.front() >= 100) {
            for(int i = 0; i < progre.size(); i++) {
                if(progre[i] >= 100) cnt++;
                else break;
            }
			for(int i = 0 ; i < cnt; i++) {
				progre.pop_front();
				speedds.pop_front();
			}
            answer.push_back(cnt);
        }
        // 하루 씩 할당 증가량 만큼 늘어납니다.
        for(int i = 0 ; i < progre.size(); i++) progre[i] += speedds[i];
    }
    return answer;
}