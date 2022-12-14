#include <iostream>
using namespace std;

int table[129][129];
int sizeTable;
int blue = 0;
int white = 0;

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
       
        check(size / 2, y, x);
        check(size / 2, y, x + size / 2);
        check(size / 2, y + size / 2, x);
        check(size / 2, y + size / 2, x + size / 2);
    
    }
    else if (zero) white++;
    else if (one) blue++;
}
int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> sizeTable;
    for (int y = 0; y < sizeTable; y++) {
        
        for (int x = 0; x < sizeTable; x++) {
            char value;
            cin >> value;
            table[y][x] = value - '0';
        }
    }

    check(sizeTable, 0, 0);
    cout << white << '\n' << blue;
    return 0;

}