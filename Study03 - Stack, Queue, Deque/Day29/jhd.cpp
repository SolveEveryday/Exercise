#include<bits/stdc++.h>
using namespace std;
string arr;
vector<char> result;
int main() {
    cin >> arr;
   
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
