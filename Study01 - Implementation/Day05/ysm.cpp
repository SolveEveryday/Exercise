#include <iostream>
#include <algorithm>
using namespace std;
int stairPoints[301]; 
int score[301];
int stairAmount = 0;


int find(int n) {

    if (n == 0) return score[0] = 0;
    if (n == 1) return score[n] = stairPoints[1];
    if (n == 2) return score[n] = stairPoints[1] + stairPoints[2];
    if (score[n] > 0) return score[n];

    score[n] = max(stairPoints[n] + find(n - 2), find(n - 3) + stairPoints[n - 1] + stairPoints[n]);

    return score[n];
}


int main() {
    int stairPoint;
    int result;

    cin >> stairAmount;

    for (int i = 1; i <= stairAmount; i++) {
        score[i] = 0;
    }
    for (int i = 1; i <= stairAmount; i++) {
        cin >> stairPoint;
        stairPoints[i] = stairPoint;
    }

    result = find(stairAmount);
    cout << result;

    return 0;
}