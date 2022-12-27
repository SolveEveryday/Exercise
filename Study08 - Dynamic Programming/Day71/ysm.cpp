#include<iostream>
#include<algorithm>
using namespace std;

int step[301];
int score[301];

int main()
{
	int number;
	cin >> number;

	for (int x = 0; x < number; x++)
	{
		cin >> step[x];
	}

	score[0] = step[0];
	score[1] = step[0] + step[1];
	score[2] = step[2] + max(step[1], step[0]);

	for (int x = 3; x < number; x++)
	{
		score[x] = step[x] + max(step[x - 1] + score[x - 3], score[x - 2]);
	}

	cout << score[number - 1];
	return 0;
}