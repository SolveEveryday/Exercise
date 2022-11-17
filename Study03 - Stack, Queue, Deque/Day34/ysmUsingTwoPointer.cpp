#include <string>
#include <vector>
#include <iostream>
 
using namespace std;
 
int solution(vector<int> queue1, vector<int> queue2) {
 
    //선언
    int answer;                         //-> 정답
    vector<int>::iterator ptr1, ptr2;   //-> 큐 포인터
    long long sum_all, sum1, sum2;      //-> 큐1+큐2합, 큐1합, 큐2합
 
    //초기화
    answer = 0;
    ptr1 = queue1.begin(), ptr2 = queue2.begin();
    sum_all = 0, sum1 = 0, sum2 = 0;
 
    /* 해법 */
    //1. 큐1, 큐2, 큐1+큐2 원소 합 구하기
    for (int i = 0; i < queue1.size(); i++) {
        sum1 += queue1[i];
        sum2 += queue2[i];
    }
    sum_all = sum1 + sum2;
 
    //2. 큐1+큐2 원소 합이 홀수일 경우 -> 불가능
    if (sum_all % 2 != 0) {
        answer = -1;
    }
    else {
        //3. 큐1, 큐2에 있는 두 개의 포인터를 조종하며 원소 합 구하기
        while (true) {
 
            //종료조건1 -> 두 큐의 합이 같을 경우
            if (sum1 == sum2) {
                break;
            }
 
            //종료조건2 -> 포인터1이 큐2 끝까지 갔을 경우 or 포인터2가 큐1 끝까지 갔을 경우(탐색완료)
            if (ptr1 == queue2.end() || ptr1 == queue1.end()) {
                answer = -1;
                break;
            }
 
            //큐의 포인터 옮기기
            if (sum1 > sum2) {
                sum1 -= *ptr1;
                sum2 += *ptr1;
                
                ptr1++;
                if (ptr1 == queue1.end()) {
                    ptr1 = queue2.begin();
                }
            }
            else {
                sum2 -= *ptr2;
                sum1 += *ptr2;
                
                ptr2++;
                if (ptr2 == queue2.end()) {
                    ptr2 = queue1.begin();
                }
            }
 
            answer++;
        }
    }
 
    //반환
    return answer;
}