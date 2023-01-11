#include<iostream>
#include<queue>
#include<vector>
using namespace std;


int main() {

	string start, result;
	cin >> start >> result;
	
	while (start.size() != result.size()) {
		if (result[result.size() - 1] == 'A') {
			result.pop_back();
			continue;
		}

		if (result[result.size() - 1] == 'B') {
			result.pop_back();
			reverse(result.begin(), result.end());
		}
	}

	if (start == result) cout << "1";
	else cout << "0";
	return 0;
}