#include<bits/stdc++.h>
using namespace std;
int N,k,a;
vector<int> arr;
int main () {
    cin >> N;

    for(int i = 0 ; i < N ; i++) {
        cin >> a;
        arr.push_back(a);
    }

    cin >> k;

    // k등분합니다.
    int ssize = N/k;

    // ssize 만큼 돌고 정렬
    // 그다음 0부터 ssize만
    for(int i = 0 ; i < i + ssize; i += ssize) {
        sort(arr.begin() + i,arr.begin() + i + ssize);
    }

    for (int a : arr) {
        cout << a <<" ";
    }
}