#include <iostream>
#include <algorithm>
using namespace std;
int house[1001][3];
int main() {
    int number;
    int cost[3];
    house[0][0] = 0;
    house[0][1] = 0;
    house[0][2] = 0;
    cin >> number;
    for (int x = 1; x <= number; x++)
    {
        cin >> cost[0] >> cost[1] >> cost[2];
        house[x][0] = min(house[x - 1][1], house[x - 1][2]) + cost[0];
        house[x][1] = min(house[x - 1][0], house[x - 1][2]) + cost[1];
        house[x][2] = min(house[x - 1][1], house[x - 1][0]) + cost[2];
    }
    cout << min(house[number][2], min(house[number][0], house[number][1]));
}