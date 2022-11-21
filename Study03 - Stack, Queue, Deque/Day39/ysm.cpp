#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {

    vector<int> time;
    vector<int> answer;
    for (int x = 0; x < progresses.size(); x++) {
        int value = (100 - progresses[x]) / speeds[x];
        int rest = (100 - progresses[x]) % speeds[x];

        if (rest == 0) {
            time.push_back(value);
        }
        else {
            time.push_back(value + 1);
        }
    }

    int timeIdx = 0;
    int cnt = 1;
    int max = time[timeIdx];
    for (int x = 0; x < time.size();x++) {
        
        if (timeIdx > 0 && time[timeIdx] <= max) {
            answer.pop_back();
        }
        if (timeIdx > 0 && time[timeIdx] > max) {
            max = time[timeIdx];
            cnt = 1;
        }
       
        answer.push_back(cnt++);
        timeIdx++;
    }

    return answer;
}

