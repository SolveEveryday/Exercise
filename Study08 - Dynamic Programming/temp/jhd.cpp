#include<iostream>
using namespace std;
int arr[1001]; 
int DP[1001];
int n, result;
int main(void) {
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> arr[i];
    }

    DP[1] = 1;
    for (int i = 2; i <= n; i++) {
        int max = 0;
        for (int j = 1; j < i; j++) {
            if (arr[j] < arr[i]) {
                if (max < DP[j]) max = DP[j];
            }
        }
        DP[i] = max + 1;
    }
   
    for (int i = 1; i <= n; i++) {
        if (result < DP[i]) result = DP[i];
    }
    cout << result;
}
// 사용한 자료구조
// 메모라이제이션을 위한 배열

// 직관적 로직
// 1. 메모라이제이션을 위한 배열생성
// 2. 기준 수열을 탐색
// 3. 1개는 무조건 들어있기 때문에 dp1는 1로 초기화
// 4. 현재 본 수열의 위치보다 이전에 있는 원소들 중에 현재 위치의 원소보다 작은지 체크합니다.
// 5. 현재 위치의 원소보다 작으면 dp[j]가 max보다 큰지 체크한다. 이 때 max 보다 크다면 j번째 원소를 포함 했을 때, 지금까지 확인한 최장 증가 부분 수열보다 더 길다는 의미이기 때문에 max에 dp[j]를 할당한다.
// 6. 현재 원소에도 포함되어야하기 때문에 dp[i] 에 max + 1을 해준다.

// 메모라이제이션 배열의 원소에서 최대값을 출력한다.

// 이유
// 가장 긴 수열의 길이를 구하는 알고리즘을 활용

// 시간/공간복잡도
// 시간 복잡도 O(N^2)
// 공간 복잡도 O(N)
// 배열을 계속해서 탐색하기 때문에 

// 성공 여부
// 성공하였습니다.
