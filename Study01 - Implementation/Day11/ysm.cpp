#include <iostream>
using namespace std;

int main() {
    int total, maxNum, jump;
    cin >> total >> maxNum >> jump;
    int idx = 1;
    
    int array[51] = { 0 };
    array[1] = 1;

    while (true) {

        if (array[idx] == maxNum) {
            array[idx]--;
            break;
        }
        
        if (array[idx] % 2 == 0) {
            idx += jump;
        }
        else {
            idx -= jump;
        }

        if (idx > total) {
            idx %= total;
        }
        else if (idx <= 0) {
            idx += total;
        }

        array[idx]++;
    }

    int sum = 0;
    for (int x = 1; x <= total; x++) {
        sum += array[x];
    }
    cout << sum;
    return 0;
}


