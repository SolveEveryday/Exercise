
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	//입력
	int n, tmp, k;
	cin >> n;
	vector<int>v;
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		v.push_back(tmp);
	}
	cin >> k;
	
    	//문제 해결
	int num = n / 2;
	while (num >=1) {
		
		int ssize = n / num; //한번에 몇 칸씩 넘어가야 하는지
		for (int i = 0; i < n-1; i=i+ssize) { 
			sort(v.begin() + i, v.begin() + i + ssize);
		}

		if (num == k) {
			//출력
			for (int i = 0; i < n; i++) cout << v[i] << ' ';
			cout << '\n';
			break;
		}

		num = num / 2;
	}
}
 


 

