#include<bits/stdc++.h>
using namespace std;
int n ;
int quadTree[65][65];

void func(int  n, int y , int x) {
    // 쿼드 트리의 크기를 N 좌표를 y,x를 인자로 받는다.
    // 기저 사례
    if(n == 1) {
        cout << quadTree[y][x];
        return;
    }
    // 1,0으로 이루어져있는지 체크한다.
    bool zero = true;
    bool one = true;

    for (int i = y; i < y + n; i++)
        for (int j = x; j < x + n; j++) 
        if(quadTree[i][j])
            zero = false;
        else 
            one = false;
    if(zero) 
        cout << 0;
    else if(one)
        cout << 1;
    else {
        // 하나의 구역에 0과 1이 섞여 있을 경우 재귀를 통해 4분면을 나눠 탐색한다.
        cout << "(";
        func(n / 2,y,x); // 왼쪽 위
        func(n / 2,y,x + n / 2); // 오른쪽 위
        func(n / 2,y + n / 2,x); // 왼쪽 아래
        func(n / 2,y + n / 2, x + n / 2); // 오른쪽 아래
        cout << ")";
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    // 초기화 작업
    for (int i = 0; i < n ; i ++) {
        string str;
        cin >> str;
        for(int j = 0 ; j< n; j++) {
            quadTree[i][j] = str[i] -'0';
        }
    }

    func(n,0,0);
    return 0;
}