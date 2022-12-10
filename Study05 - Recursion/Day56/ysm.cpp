#include <iostream>
using namespace std;

int table[65][65];
int sizeTable;

void check(int size, int y, int x) {
    
    bool zero = false;
    bool one = false;
    for (int t = y; t < y + size; t++) {
        for (int k = x; k < x + size; k++) {
            if (table[t][k] == 0) {
                zero = true;
            }

            if (table[t][k] == 1) {
                one = true;
            }
        }
    }

    if (zero && one) {
        cout << "(";
        check(size / 2, y, x);
        check(size / 2, y, x + size / 2);
        check(size / 2, y+size/2, x);
        check(size / 2, y+size/2, x+size/2);
        cout << ")";
    }
    else if (zero) cout << 0;
    else if (one) cout << 1;
}
int main() {
    
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> sizeTable;
    for (int y = 0; y < sizeTable; y++) {
        string value;
        cin >> value;
        for (int x = 0; x < sizeTable; x++) {
        
            table[y][x] = value[x] - '0';
        }
    }

    check(sizeTable, 0, 0);
    return 0;

}