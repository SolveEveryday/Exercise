#include <iostream>
#include <queue>
using namespace std;
 
//시작 시간 기준, 같으면 종료 시간을 기준으로 정렬
struct compare {
    bool operator()(pair<int, int> p1, pair<int, int> p2) {
        if (p1.first == p2.first) {
            return p1.second > p2.second;
        }
        else {
            return p1.first > p2.first;
        }
    }
};
 
int main() {
    int N;
    //시작, 종료 시간 저장 pq
    priority_queue<pair<int, int>, vector<pair<int, int>>, compare> pq_time;
    //종료 시간 저장 pq (size=강의실 개수)
    priority_queue<int, vector<int>, greater<int>> pq_room;
    
    cin >> N;    
    for (int i = 0; i < N; i++) {
        int s, t;
        cin >> s >> t;
        pq_time.push(make_pair(s, t));
    }
 
    while (!pq_time.empty()) {
        pair<int, int> temp = pq_time.top();
        pq_time.pop();
 
        if (pq_room.empty()) {
            pq_room.push(temp.second);
        }
        else {
            //새로운 강의의 시작 시간이 현재 강의실의 종료 시간보다 크면 강의 종료 = 강의실 제거
            if (temp.first >= pq_room.top()) {
                pq_room.pop();
                pq_room.push(temp.second);
            }
            else {
                pq_room.push(temp.second);
            }
        }
    }
 
    cout << pq_room.size();
 
    return 0;
}