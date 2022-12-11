#include <bits/stdc++.h>
using namespace std;

set<string> se;
string result;
string arr="AEIOU";
void permutation(){
    if(result.length()>5){
        return;
    }
    if(result.length()>0){
        se.insert(result);
    }
    for(int i=0; i<5;i++){
        result+=arr[i];
        permutation();
        result.pop_back();
    }
}

int solution(string word) {
    int answer = 0;
    
    permutation();
    for(auto o : se){
        answer++;
        if(o==word){
            return answer;
        }
    }
    return answer;
}