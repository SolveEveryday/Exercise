#include<bits/stdc++.h>
using namespace std;
bool check(string s){
   {
    stack<int> st;
    
    // s 문자열 순회
    for(int i = 0; i < s.length(); i++)
    {
        if (s[i] == '(')
        {
            st.push(s[i]);
        }
        
        if (s[i] == ')')
        {
            if (!st.empty())
                st.pop();
        }
    }
    
    // s 문자열 순회 끝
    if (st.empty()) return true;
    else return false;
}
}

string removeAndReverse(string u)  // 4-4 의 과정
{
    u.erase(u.begin());   // u의 첫번쨰 문자 제거
    u.erase(u.end() - 1); // u의 마지막 문자 제거
    
    for(int i = 0; i < u.length(); i++) // 괄호 방향 뒤집기
    {
        if (u[i] == '(') u[i] = ')'; 
        else if (u[i] == ')') u[i] = '(';
    }
    
    return u;
}

string convert(string w)
{
     if(w == "") return w;// 빈문자열 출력

     // w = u,v로 분리. "균형잡힌 괄호 문자열" 찾으면 바로 break하고 그걸 u에 담고 나머지 v
     int openCnt =0; 
     int closeCnt = 0;
     int index = 0;
     // 균형잡힌 문자열까지만 확인하고 인덱스 저장 후 브레이크 나머지는 v
     for (int i =0; i < w.length(); i++) {
        if(w[i] == '(') openCnt++;
        if(w[i] == ')') closeCnt++;
        if(openCnt == closeCnt) {
            index = i + 1;
            break;
        }
     }

     string u = w.substr(0,index);
     string v = w.substr(index);

     string result = "";
     if(check(u)) // 문자열 u가 "올바른 문자열"
        result = u + convert(v);
    else // 올바른 괄호 문자열이 아니라면
        // .     4-1 .  4-2 .      4-3 .    4-4. 
        result = "(" + convert(v) + ")" + removeAndReverse(u);

    return result;    
}

string solution(string p) {
     ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    
   return convert(p);
}