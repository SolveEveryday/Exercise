#include <vector>
#include <algorithm>
using namespace std;

vector<int> parent(101);

bool cmp(const vector<int>& a, const vector<int>& b)
{
	return a[2] < b[2];
}

int find(int x)
{
	if (x == parent[x]) return x;
	else return parent[x] = find(parent[x]);
}

int merge(int a, int b)
{

	a = find(a);
	b = find(b);

	if (a == b) return false;
	else
	{
		if (a > b) parent[a] = b;
		else parent[b] = a;
	}
	return true;
}

int solution(int n, vector<vector<int>> costs)
{
	int answer = 0;
	for (int x = 0; x < n; x++) parent[x] = x;

	sort(costs.begin(), costs.end(), cmp);
	for (int x = 0, size = costs.size(); x < size; x++)
		if (merge(costs[x][0], costs[x][1]) == true) answer += costs[x][2];

	return answer;
}