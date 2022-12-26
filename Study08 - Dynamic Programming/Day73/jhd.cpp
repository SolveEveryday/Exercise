#include<stdio.h>
using namespace std;
int main() {
	int i, j, n, max = 0, d[1001], a[1001];	scanf("%d", &n);
	for (i = 1; i <= n; i++) scanf("%d", &a[i]);

	// 주어진 수 처음부터 끝까지 반복한다.
	for (i = 1; i <= n; i++) {
		// 지속적으로 증가하는 수의 개수를 1로 초기화한다.(자기 자신)
		d[i] = 1;
		// i가 증가할 때마다
		for (j = 1; j < i; j++) {
			// 처음 인덱스의 값부터 현재 값보다 작고 d[i]값들 중 가장 큰 값을 찾아서 d[i]의 값을 제일 큰값으로 바꿔주고 +1을 한다.
			if (a[j] < a[i] && d[i] < d[j] + 1) {
				d[i] = d[j] + 1;
			}
		}

		// 현재 인덱스번째의 값이 Max보다 크다면 현재 값을 최대 개수로 초기화 해준다.
		if (max < d[i]) max = d[i];
	}
	printf("%d", max);
    return 0;
}
