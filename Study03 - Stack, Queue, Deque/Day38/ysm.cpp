#include <string>
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int solution(int len, int weight, vector<int> truck) {
	int answer = 0; 
	int curWeight = 0;
	int idx = 0; 
	queue<int> q;
	while (1) {
		answer++;
		if (q.size() == len) {
			curWeight -= q.front();
			q.pop();
		}
		if (curWeight + truck[idx] <= weight) {
			if (idx == truck.size() - 1) {
				answer += len;
				break;
			}
			q.push(truck[idx]);
			curWeight += truck[idx];
			idx++;
		}
		else {
			q.push(0); 
		}
	}
	return answer;
}
