#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int amount;
    int number[2000001] = { 0 };
    int a;
    cin >> amount;
    for (int x = 0; x < amount; x++) {
        cin >> a;
        number[a + 1000000]++;
        
        
    }

    for (int x = 0; x < 2000001; x++) {
        if (number[x] > 0) {
            cout << x - 1000000 << '\n';
            
        }
    }
    return 0;
}


