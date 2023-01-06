#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int test_case,days;
ll result,a,max_r;

int main() {
// 기본적인 개념은 맨 뒤부터 최대값을 찾아서 
cin >> test_case;
for(int i = 0; i < test_case; i++) {
  vector<long long> arr;
  
  cin >> days;
  for(int j = 0 ; j < days; j++) {
    cin >> a;
    arr.push_back(a);
  }

  max_r = -1;
  result = 0;
  for(int j = days - 1; j >= 0; j--) {
    max_r = max(max_r,arr[j]);
    result += max_r - arr[j];
  }

  cout << result << "\n";
}

return 0;
}