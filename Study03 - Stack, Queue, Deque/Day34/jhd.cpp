#include<bits/stdc++.h>
using namespace std;

// 오답풀이
int solution(vector<int> queue1, vector<int> queue2) {
    // 문제에서 친철하게 오버플로우 발생 가능성을 말해줬으므로 크기가 큰 long 타입으로 지정하였습니다.

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

    int size = queue1.size() ;
    int answer = 0;
    // 두 배열의 길이가 같습니다. 두 배열의 길이의 합만큼 변경이 발생하면 배열의 위치가 변경됩니다.(size() * 2)
    // 다시 원상태로 돌아오려면 위 작업을 한번 더 하면 됩니다. 원 위치가 되면 한바퀴 돌았기 때문에
    // 다시 원상태가 되기 전까지만 확인하면 됩니다.
    for(int i = 0; i < size * 4; i++ )
    {   
        // 반복중에 두개의 합이 같아지게 되면 지금 까지 카운트한 횟수를 반환합니다.
        if (sum == sum2)
        {
            return answer;
        }

        // 같지 않다면 둘의 크기가 어떻든 작업은 무조건 이루어집니다.
        answer++;   

        // 두 배열 중에 큰 배열에서 작은 배열로 한개씩 옮겨야하기 때문에 조건에 따라 작업이 달라집니다.
        if (sum < sum2)
        {
            int qfront = q2.front();
            q2.pop();

            q.push(qfront);
            sum += qfront;
            sum2 -= qfront;
            
        }
        else
        {
            int qfront = q.front();
            q.pop();

            q2.push(qfront);
            sum2 += qfront;
            sum -= qfront;
        }
    }

    return -1;
}