#include<bits/stdc++.h>
using namespace std;
int n;
int main() {
    cin >> n;
    int i = 666;

    for(;;i++){
        if(to_string(i).find("666") != string::npos) n--;
        if(n == 0) break;
    }

    cout << i << "\n";
}