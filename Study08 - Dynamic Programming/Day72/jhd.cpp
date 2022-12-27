#include <iostream>
#define endl "\n"
#define MAX 110
using namespace std;
 
int N, K;
// 각 물건의 무게
int Weight[MAX];
// 각 물건의 가치
int Value[MAX];

// F[A][B] = C :: A번째 물건까지 왔고, 가방의 무게가 B일 때 가방에 담긴 물건들의 가치가 C이다.
int DP[MAX][100010];
 
int Max(int A, int B) { if (A > B) return A; return B; }
 
int main(void)
{
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    // 초기화
    cin >> N >> K;
    for (int i = 1; i <= N; i++){
        cin >> Weight[i] >> Value[i];
    }



    // 1번부터 N번까지 탐색하기 위한 반복문
    for (int i = 1; i <= N; i++)
        {
            // 가방의 무게를 1부터 K까지 확인 --> 제한 무게를 1부터 확인
            // i번째 물건을 통해서 가방의 무게 J만들기
            for (int j = 1; j <= K; j++)
            {
                // I번째 물건의 무게가 j보다 작다면
                // 현재 물건의 무게가, 만들고자 하는 가방의 무게보다는 크거나 같아야한다. 
                if (j >= Weight[i]) 
                {
                    // DP[i - 1][j] : 기존에 탐색했던 물건들로만 무게 j를 만드는 경우
                    // DP[i - 1][j - Weight[i]] + Value[i] : 기존에 탐색했던 물건들로만 무게 j - Weight[I] 를 만들고, 현재 물건을 가방에 넣는 경우”
                    DP[i][j] = Max(DP[i - 1][j], DP[i - 1][j - Weight[i]] + Value[i]);
                } else{
                    DP[i][j] = DP[i - 1][j];
                } 
            }
        }

    cout << DP[N][K] << endl;
 
    return 0;
}
