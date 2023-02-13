#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	string s; cin >> s;
	
	int sum[26][200001] = {0,};
	for(int i=0;i<s.length();i++){
		sum[s[i] - 'a'][i+1]++;
	}
	
	for(int i=1;i<=s.length();i++){
		for(int j=0;j<26;j++){
			sum[j][i] = sum[j][i-1] + sum[j][i];
		}
	}
	
	int n; cin >> n;
	for(int i=0;i<n;i++){
		char a; cin >> a;
		int b, c; cin >> b >> c;
		cout << sum[a - 'a'][c+1] - sum[a - 'a'][b] << '\n';
	}
	
	return 0;
}