#include<bits/stdc++.h>
using namespace std;

int n, size;
string a;

bool check(string s) {
    stack<char> stk;
    for(char c : s) {
        if (c == '('){
            stk.push(c);
        }else{
            if(!stk.empty())stk.pop();
            else return false;
        }
    }
    return stk.empty();
}

int main() {
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> a;
        if(check(a)){
            cout << "YES\n";
        }else{
            cout << "NO\n";
        }
    }
return 0;
}