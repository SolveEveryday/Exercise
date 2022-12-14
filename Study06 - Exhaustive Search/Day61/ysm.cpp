#include <bits/stdc++.h>
using namespace std;

string num[10]={"0","1","2","3","4","5","6","7","8","9"};

void make(vector<string>& ret, string s, int d, int pos, int n){
    if(pos >= n){
        ret.push_back(s);
        return;
    }
    
    for(int i=0; i<d; ++i){
        make(ret, s + num[i], i, pos+1, n);
    }
}

int main(){
    int k, K;
    scanf("%d", &K);
    if(K > 1023) return puts("-1"), 0;
    
    vector<string> result;
    for(k=0; k<=K;){
      
        for(int i=1; i<=10; ++i){
            vector<string> v;
            make(v, "", 10, 0, i);
            for(int j=0; j<v.size(); ++j) result.push_back(v[j]);
            k += v.size();
        }
    }
    puts(result[K-1].c_str());
    return 0;
}