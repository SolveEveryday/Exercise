#include <iostream>
#include <vector>
using namespace std;

int N;
vector<pair<int, int>> v;

void Hanoi(int num, int from, int by, int to) {

    if (num == 1) v.push_back({ from, to });

    else {
        Hanoi(num - 1, from, to, by);
        v.push_back({ from, to });
        Hanoi(num - 1, by, from, to);
    }
}

int main(void) {

    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    cin >> N;

    Hanoi(N, 1, 2, 3);
    cout << v.size() << "\n";

    for (int i = 0; i < v.size(); i++) {
       cout << v[i].first << " " << v[i].second << "\n";
    }
    return 0;

}