#include<bits/stdc++.h>
using namespace std;
string arr;
vector<char> result;
int main() {
    cin >> arr;
    result.push_back(arr[0]);
    for (int i = 1; i < arr.size(); i++) {
        if (result.back() == '(' && arr[i] == ')') {
        result.pop_back();
        }else {
        result.push_back(arr[i]);
    }
    }
   for (char a : arr) {
    if(result.empty()){
        result.push_back(a);
        continue;
    }

    if (result.back() == '(' && a == ')') {
        result.pop_back();
    }else {
        result.push_back(a);
    }

   
   }

    cout << result.size();
    return 0;
}
