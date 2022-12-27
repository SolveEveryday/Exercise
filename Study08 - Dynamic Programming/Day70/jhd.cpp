#include<bits/stdc++.h>
using namespace std;

// 메모제이션
int dpValue[21][21][21];


int w(int a, int b, int c){
    // 기저사례
    if( a<= 0 || b <= 0 || c <= 0) return 1;

    // 메모제이션 활용 -> dp의 강점 기존의 값을 가지고 있으면 아래 로직 없이 바로 리턴
	if(dpValue[a][b][c] != 0) return dpValue[a][b][c];
    
    // 제공받은 로직
    if( a > 20 || b > 20 || c > 20) return w(20,20,20);
    if( a < b && b < c) {
        dpValue[a][b][c] = w(a,b,c -1) + w(a,b-1,c-1) - w(a, b-1,c);
        return dpValue[a][b][c];
    }
    else {
        dpValue[a][b][c] = w(a -1 , b, c) + w(a -1 , b -1 , c) + w(a -1, b, c-1) - w(a - 1, b - 1, c - 1);
        return dpValue[a][b][c];
    }
    return 0;
}


int main(){
	int a,b,c;
    while(true){
        cin >> a >> b >> c;
        if(a == -1 && b == -1 && c == -1) break;
        cout << "w(" << a << ", " <<  b<< ", " << c << ") = " <<  w(a,b,c) << "\n";
    }
    return 0;
}