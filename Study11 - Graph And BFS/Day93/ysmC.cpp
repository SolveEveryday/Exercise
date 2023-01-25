#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;
const int MAX = 50;

typedef struct {
    int y, x;

}Dir;


Dir moveDir[4] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

int N, L, R;
int people, num;
int graph[MAX][MAX];
bool visited[MAX][MAX];
vector<pair<int, int>> v;

void DFS(int y, int x)

{
    for (int i = 0; i < 4; i++) {
       int nextY = y + moveDir[i].y;
       int nextX = x + moveDir[i].x;
       int diff = abs(graph[y][x] - graph[nextY][nextX]);
       if (0 <= nextY && nextY < N && 0 <= nextX && nextX < N)
       if (L <= diff && diff <= R && !visited[nextY][nextX])
        { //조건 충족할 경우에만
           visited[nextY][nextX] = true;
           v.push_back({ nextY, nextX });
           people += graph[nextY][nextX];
           num++;
           DFS(nextY, nextX);
        }
    }

}



int main(void) {

    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    cin >> N >> L >> R;
    for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++) cin >> graph[i][j];

    int result = 0;

    while (1) {

        memset(visited, false, sizeof(visited));

        bool found = false;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {

                if (visited[i][j]) continue;
                visited[i][j] = true;
                people = graph[i][j];
                num = 1;
                v.clear();
                v.push_back({ i, j });
                DFS(i, j);
        
                if (num >= 2) {

                    found = true;
                    //업데이트
                    for (int i = 0; i < v.size(); i++) {
                        graph[v[i].first][v[i].second] = people / num;
                    }
                }

            }

        if (found) result++;
        else break;
    }

    cout << result << "\n";

    return 0;
}