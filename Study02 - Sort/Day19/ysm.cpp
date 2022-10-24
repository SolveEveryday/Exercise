#include <stdio.h>
#include <iostream>
using namespace std;

int r, c, k, R, C, map[105][105];

void sort()
{
	int idx = 1, i, j;
	int save[105][105] = { 0 };
	if (R >= C)
	{
		while (idx <= R)
		{
			int check[105] = { 0 };
			int max1 = 0, max2 = 0;
			for (i = 1; i <= C; i++)
			{
				check[map[idx][i]]++;
				if (map[idx][i] > max2)
					max2 = map[idx][i];
				if (check[map[idx][i]] > max1)
					max1 = check[map[idx][i]];
			}
			int a = 0;
			for (i = 1; i <= max1; i++)
				for (j = 1; j <= max2; j++)
					if (check[j] == i)
					{
						save[idx][++a] = j;
						save[idx][++a] = check[j];
					}
			if (a >= C)
				C = a;
			idx++;
		}
	}
	else
	{
		while (idx <= C)
		{
			int check[105] = { 0 };
			int max1 = 0, max2 = 0;
			for (i = 1; i <= R; i++)
			{
				check[map[i][idx]]++;
				if (map[i][idx] > max2)
					max2 = map[i][idx];
				if (check[map[i][idx]] > max1)
					max1 = check[map[i][idx]];
			}
			int a = 0;
			for (i = 1; i <= max1; i++)
				for (j = 1; j <= max2; j++)
					if (check[j] == i)
					{
						save[++a][idx] = j;
						save[++a][idx] = check[j];
					}
			if (a >= R)
				R = a;
			idx++;
		}
	}
	for (i = 1; i <= R; i++)
		for (j = 1; j <= C; j++)
			map[i][j] = save[i][j];
}

int main()
{
	cin >> r >> c >> k;
	int i, j;
	for (i = 1; i <= 3; i++) {
		for (j = 1; j <= 3; j++) {
			cin >>  map[i][j];
		}
	}
			
	R = 3, C = 3;
	int cnt = 0;
	while (cnt <= 100)
	{
		if (map[r][c] == k)
			break;
		sort();
		cnt++;
	}
	if (cnt > 100)
		cout << -1;
	else
		cout << cnt;
}