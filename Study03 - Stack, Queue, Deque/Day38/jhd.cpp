#include<bits/stdc++.h>
using namespace std;
int answer, bridge_sum, last_idx;
deque<int> waitTrucks;
queue<int> on_bridge;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    for(auto a : truck_weights) {
		waitTrucks.push_back(a);
	}
    while(1) {
        if(waitTrucks.empty()) {
            answer += bridge_length;
            break;
        }
        
        answer++;
        
        int nowTruck = waitTrucks.front();
        
        if(on_bridge.size()== bridge_length) {
            bridge_sum -= on_bridge.front();
            on_bridge.pop();
        }
        
        if(bridge_sum + nowTruck <= weight) {
            on_bridge.push(nowTruck);
            bridge_sum += nowTruck;
            waitTrucks.pop_front();
        }
        else {
            on_bridge.push(0);
        }
    }
    return answer;
}