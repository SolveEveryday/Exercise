#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

bool flag;
string S, T;

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> S >> T;

	//T로부터 역순으로 진행할 때 S가 되는지 여부 파악
	while (1)
	{
		if (S.length() == T.length())
		{
			if(S == T)
				flag = true;
			break;
		}

		char c = T[T.length() - 1];
		T.pop_back();
		if (c == 'B')
			reverse(T.begin(), T.end());
	}
	cout << flag << "\n";
	return 0;
}