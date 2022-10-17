#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int amount, input;
    cin >> amount;
    int number[10001] = { 0 };
    for (int x = 0; x < amount; x++) {
        cin >> input;
        number[input]++;
    }

    for (int y = 1; y < 10001; y++) {
        if (number[y] == 0) continue;
        for (int x = 1; x <= number[y]; x++) {
            cout << y << '\n';
        }
        
    }
    return 0;
}


