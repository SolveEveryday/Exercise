#include <iostream>
using namespace std;

int main() {
    int amount, number;
    cin >> amount >> number;
    int gold[1001] = { 0 };
    int silver[1001] = { 0 };
    int bronze[1001] = { 0 };
    for (int x = 1; x <= amount; x++) {
        int index;
        cin >> index;
        cin >> gold[index] >> silver[index] >> bronze[index];
    }
    int score = 1;
    for (int x = 1; x <= amount; x++) {
        if (gold[x] > gold[number]) {
            score++;
        }
        else if (gold[x] == gold[number]) {
            if (silver[x] > silver[number]) {
                score++;
            }
            else if (silver[x] == silver[number]) {
                if (bronze[x] > bronze[number]) {
                    score++;
                }
            }
        }
    }

    cout << score;
    return 0;
}


