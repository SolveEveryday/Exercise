#include<bits/stdc++.h>
using namespace std;

void hanoi(int n, int from, int by, int to){
    if(n == 1){
        cout << from << " " << to << "\n";
        return;
    }
    hanoi(n-1,from,to,by);
    cout << from << " " << to << "\n";
    hanoi(n-1,by,from,by);
}

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    int n ;
    cin >> n;
    cout << (1<<n) -1 << "\n";
    hanoi(n,1,2,3);
    return 0;
}