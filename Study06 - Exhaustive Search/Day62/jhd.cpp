#include<bits/stdc++.h>
using namespace std;
int N,M;


string WB[8] = {"WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW"};
                
string BW[8] = { "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB"};

string arr[50];
// WB와 비교 시작 좌표
int WB_cnt(int x, int y){
    int cnt = 0;
    for(int i = 0; i < 8; i++)
    {
        for(int j = 0; j < 8; j++)
        {
            if(arr[x+i][y+j] != WB[i][j])
                cnt++;
        }

    }
    return cnt;
}

// BW와 비교
int BW_cnt(int x, int y){
    int cnt = 0;
    for(int i = 0; i < 8; i++)
    {
        for(int j = 0; j < 8; j++)
        {
            if(arr[x+i][y+j] != BW[i][j])
                cnt++;
        }

    }
    return cnt;
}

int main(){
    cin >> N >> M;
    int minCnt = 3000;
    for(int i = 0; i < N; i++) {
        cin >> arr[i];
    }
    
    for(int i = 0; i + 8 <= N; i++)
    {
        for(int j = 0; j + 8 <= M; j++)
        {
            int tmp;
            tmp = min(WB_cnt(i,j),BW_cnt(i,j));
            if(tmp < minCnt) {
                minCnt = tmp;
            }
        }
    }

    cout << minCnt;
    return 0;
}