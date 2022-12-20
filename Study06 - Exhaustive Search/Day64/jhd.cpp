#include<bits/stdc++.h>
using namespace std;
int E,S,M;
int result = 1;
int main() {
    //1 16 16
    cin >> E>> S >> M;
    while(1){
        if((result - E)%15 == 0 && (result - S)%28 == 0 && (result - M)%19 == 0) {
        cout << result;
        break;
        }else {
            result ++;
        }
    }
}