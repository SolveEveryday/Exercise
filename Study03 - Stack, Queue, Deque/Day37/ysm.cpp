#include <iostream>
#include <algorithm>
using namespace std;

int n;
int height[1001];
int area[1001];
int main()
{
	cin >> n;
	while (n--)
	{
		int L, H;
		cin >> L >> H;
		height[L] = H;
	}

	for (int i = 1; i <= 1000; i++) {
		area[i] = max(height[i], area[i - 1]);
	}

	
	for (int i = 1000; i >= 0; i--) {
		area[i] = min(area[i], max(height[i], area[i + 1]));
	}

	int ret = 0;
	for (int i = 1; i <= 1000; i++) {
		ret += area[i];
	}

	cout << ret << '\n';
	return 0;
}