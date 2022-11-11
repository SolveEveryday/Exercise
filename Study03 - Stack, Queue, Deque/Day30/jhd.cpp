#include<bits/stdc++.h>
using namespace std;
stack<char> stk;
int result;
string arr;
int main() {
    cin >> arr;
    for (int i = 0; i < arr.size(); i++) {

      if(arr[i] == '(') stk.push(arr[i]);
      
      if(arr[i] == ')') {
        if(arr[i - 1] == '(') {
            stk.pop(); 
            result += stk.size();
        } else {
            stk.pop();
            result++;
        }
      }
    }

    cout << result;
}
