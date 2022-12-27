#include<bits/stdc++.h>
using namespace std;
#define MAX 301
// 각 step의 최대값으 메모라이제이션을 위한 vector
int DP[MAX];
// 기존 초기화 배열 
int arr[MAX];
int N, a;
int main() {
    cin >> N;

    for (int i = 1 ; i <= N ;i++) {
        cin >> arr[i];
    }

    // 최대값을 구하는데는 규칙이 존재한다.
    // 만약 arr[N]번째의 최대값을 생각해 보려면 조건에 나와 있는 규칙을 만족하려면
    // N-1 번째 계단을 밟은 경우와 그렇지 않은 경우로 나눠진다. 그 두개의 조건 중에 큰 최대값을 구하면 된다.
    // arr[N]의 최대값을 구하려면 이전 값이 최소 3개는 필요하다. arr[N-3], arr[N-2] ,arr[N-1] , arr[N]
    // 따라서 우선적으로 arr[3]까지의 최대값은 가지고 있어야한다. 
    DP[1] = arr[1];
	DP[2] = arr[1] + arr[2];
	DP[3] = max(arr[1]+arr[3], arr[2]+arr[3]);
    
    // 그 다음부터 규칙으로 정해놓은 값들을 진행한다.
    // N-1 번째 계단을 밟은 경우와 그렇지 않은 경우로 나눠진다.
    // n-1을 밟지 않는 경우 : DP[n] = DP[n - 2] + arr[n]
    // n-1을 밟는 경우 : DP[n] = DP[n - 3] + arr[n - 1] + arr[n]
    // 둘중에 최대값 하나를 구하면 N번째까지의 최대값을 구할 수 있다. 
	for (int j = 4; j <= N; j++) {
		DP[j] = max(DP[j - 2] + arr[j], DP[j - 3] + arr[j - 1] + arr[j]);
	}

	cout << DP[N];
	return 0;
}
