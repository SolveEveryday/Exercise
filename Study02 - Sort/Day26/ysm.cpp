#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int n;
vector<pair<long long, long long> > arr;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n;
    long long total=0;
    for(int i=0 ; i<n ; i++) {
        long long x,a;
        cin >> x >> a;
        arr.push_back(make_pair(x, a));
        total += a;
    }
    sort(arr.begin(), arr.end());
    long long temp=0;
    for(int i=0 ; i<n ; i++) {
        temp += arr[i].second;
        if(temp>=(total+1)/2) { 
            cout << arr[i].first << "\n";
            break;
        }
    }
    
    return 0;
}