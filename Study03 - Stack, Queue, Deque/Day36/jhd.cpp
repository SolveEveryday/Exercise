#include<bits/stdc++.h>
using namespace std;
int N;

int main() {
    
    cin >> N;
    int result = 0;
    while (N--) {
        stack<char> stk;
        string word;
        cin >> word;
 
        for (int i = 0; i < word.size(); i++) {
            if (stk.empty()) stk.push(word[i]);
            else {
                if (stk.top() == word[i]) stk.pop();
                else stk.push(word[i]);
            }
        }
 
        if (stk.empty()) {
            result++;
        }
    }
 
    cout << result;
}
