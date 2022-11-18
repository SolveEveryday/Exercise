#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(vector<int> queue1, vector<int> queue2) {
    long long sum = 0, sum2 = 0;
    queue<int> q, q2;

    for (int num : queue1) {
        sum += num;

        q.push(num);
    }

    for (int num : queue2) {
        sum2 += num;

        q2.push(num);
    }

    int idx = 0, idx2 = 0;
    int maxIdx = queue1.size() + queue2.size();
    int answer = 0;

    while (idx < maxIdx && idx2 < maxIdx)
    {
        if (sum == sum2)
        {
            return answer;
        }

        answer++;

        if (sum < sum2)
        {
            int cur = q2.front();
            q2.pop();

            q.push(cur);
            sum += cur;
            sum2 -= cur;
            idx2++;
        }
        else
        {
            int cur = q.front();
            q.pop();

            q2.push(cur);
            sum2 += cur;
            sum -= cur;
            idx++;
        }
    }

    return -1;
}