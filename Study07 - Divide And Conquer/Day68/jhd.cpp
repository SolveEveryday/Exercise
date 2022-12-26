#include<bits/stdc++.h>
using namespace std;

void go(int n){
   if(n==0){
        cout << "-";
        return;
    }
    go(n-1);
    
    for(int i=0; i< pow(3, n-1); i++)
        cout << " ";

    go( n-1 );
}

int main() {
    int N;
    while(cin >> N){
        go(N);
        cout << "\n";
    }
    return 0;
}