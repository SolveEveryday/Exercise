#include <bits/stdc++.h>
using namespace std;
int n,i,j, flag;
vector <string> ticketInfo, sequence;
stack <string> stk;
// 1. 그대로 받는다.
// 2. 해당 배열을 정렬한다.
// 2. 순서대로 정렬한 배열은 판단의 기준이 됩니다. 
// 3. 
bool cmp(string &a, string &b){
    string alpha = a.substr(0,1);
    string alpha2 = b.substr(0,1);
    int num1 = stoi(a.substr(2));
    int num2 = stoi(b.substr(2));
    if(alpha == alpha2) return num1 < num2;
    return a < b;
}

int main(){
    cin >> n;
    for(int i = 0; i < n*5; i++){
        string ticket;
        cin >> ticket;
        ticketInfo.push_back(ticket);
    }
    
    sequence = ticketInfo;
    sort(sequence.begin(),sequence.end(),cmp);
    
    while(i < 5 * n && j < 5 * n){
       
        if(ticketInfo[i] == sequence[j]) i++, j++;
       
        else if(!stk.empty() && stk.top() == sequence[j]) stk.pop(), j++;

        
        else stk.push(ticketInfo[i++]);
    }

    while(!stk.empty()){
        // 스택의 탑이 순서
        if(stk.top()!=sequence[j++]){
            flag = 1;
            break;
        }
        stk.pop();
    }   

    if(flag) cout << "BAD\n";
    else cout << "GOOD\n";
}