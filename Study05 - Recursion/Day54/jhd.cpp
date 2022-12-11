#include<bits/stdc++.h>
using namespace std;

// 높이 : n , 밑변 2n -1;
char _map[3072][6144];

void star(int x, int y, int n){
    if(n == 3) {
        //높이가 3일때 별을 찍는다.
        _map[x][y] = '*'; // 첫번째 줄
        _map[x + 1][y - 1] = '*'; // 두번째 줄
        _map[x + 1][y + 1] = '*'; // 두번째 줄

        // 세번째 줄 
        for(int i = y -2; i <= y+2; i++) {
            _map[x + 2][i] = '*';
        }
    return;
    }

    star(x,y,n/2); // 위쪽 삼각형
    star(x + n/2, y -n/2, n/2); // 왼쪽 아래 삼각형
    star(x + n/2, y +n/2, n/2); // 오른쪽 아래 삼각형

    
}

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    int n;

    cin >> n;
    // 초기화
    for (int i = 0 ; i < n; i++) {
        for(int j = 0; j < 2*n; j++) {
            _map[i][j] = ' ';
        }
    }
    // 재귀호출
    star(0,n - 1,n);

    for (int i = 0 ; i < n; i++) {
        for(int j = 0; j< 2*n -1; j++) {
            cout << _map[i][j];
        }
        cout << "\n";
    }
    return 0;
}