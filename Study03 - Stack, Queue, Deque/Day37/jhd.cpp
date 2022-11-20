#include<bits/stdc++.h>
using namespace std;

int n, a, b, left_max,left_locat, right_h, right_locat, result;
vector<pair<int,int>> v;
map<int,int> _map;


int main() {
	cin >> n;
	for (int i = 0; i < n ; i++ ) {
		cin >> a >> b;
		_map.insert({a,b});
	}
	for(auto x : _map){
		v.emplace_back(make_pair(x.first,x.second));
	}
	left_locat = v[0].first;
	left_max = v[0].second;
	// 처음 더 높은 막대기 만나면 계산하고 높이 변경.
	for(auto q : v) {
		if(q.second >= left_max){
			result += (q.first - left_locat) * left_max;
			left_max = q.second;
			left_locat = q.first;
		}
	}
	right_h = v.back().second;
	right_locat = v.back().first;

	for (int i = v.size()-1; i > -1; i--){
		if(v[i].second > right_h){
			result += (right_locat - v[i].first) * right_h;
			right_h = v[i].second;
			right_locat = v[i].first;
		}
	}
	cout << result + left_max << endl;

    return 0;
}

