#include <iostream>
#include <vector>
using namespace std;

vector<vector<char>>star;
void Make_Star(int N, int y, int x) {
    if (N == 3) {
        star[y][x] = '*';
        star[y + 1][x - 1] = star[y + 1][x + 1] = '*';
        for (int idx = 0; idx < 5; ++idx)
            star[y + 2][x - 2 + idx] = '*';
    }
    else {
        Make_Star(N / 2, y, x);
        Make_Star(N / 2, y + N / 2, x - N / 2);
        Make_Star(N / 2, y + N / 2, x + N / 2);
    }
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int N = 0;
    int y = 0, x = 0;
    cin >> N;

    star = vector<vector<char>>(N, vector<char>(N * 2 - 1, ' '));

    Make_Star(N, 0, N - 1);

    for (y = 0; y < N; ++y) {
        for (x = 0; x < N * 2 - 1; ++x) {
            cout << star[y][x];
        }
        cout << '\n';
    }
}