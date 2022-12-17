#include <iostream>
#include <vector>
#include <set>
#include <string>
using namespace std;

int choose;
int number;
vector<string> path(choose);
int used[10] = { 0 };
set<int> s;

void makePath() {
	string sen = "";
	for (int x = 0; x < choose; x++) {
		sen += path[x];
	}
	int isen = stoi(sen);
	s.insert(isen);
}
void run(int level, vector<string> arr) {
	if (level == choose) {
		makePath();
		return;
	}

	for (int x = 0; x < number; x++) {
		if (used[x] == 1) continue;
		path.push_back(arr[x]);
		used[x] = 1;
		run(level + 1, arr);
		path.pop_back();
		used[x] = 0;
	}
}
int main() {
	
	
	cin >> number >> choose;

	vector<string> v(number);
	for (int x = 0; x < number; x++) {
		cin >> v[x];
	}

	run(0, v);
	cout << s.size();
}