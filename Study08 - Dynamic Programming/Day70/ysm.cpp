#include <iostream>

using namespace std;
int arr[21][21][21];

int w(int a, int b, int c)
{
	if (a <= 0 || b <= 0 || c <= 0)
		return 1;

	else if (a > 20 || b > 20 || c > 20)
		return w(20, 20, 20);

	else if (arr[a][b][c] != 0) return arr[a][b][c];	//이미 저장된 값이라면

	else if (a < b && b < c)
		arr[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);	// 저장이 안된 값

	else
		arr[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1); // 저장이 안된 값

	return arr[a][b][c];
}

int main(void)
{
	int a, b, c;
	while (1)
	{
		cin >> a >> b >> c;
		if (a == -1 && b == -1 && c == -1) break;
		cout << "w(" << a << ", " << b << ", " << c << ") = " << w(a, b, c) << endl;
	}
	return 0;
}