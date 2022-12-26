#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <cmath>
#include <stdio.h>
using namespace std;

vector<string> v;
int sizeArray;
void run(int start, int size) {
    if (size == 1) {
        return;
    }

    int divSize = size / 3;
    for (int x = divSize + start; x < 2 * divSize + start; x++) {
        v[x] = " ";
    }

    run(start, divSize);
    run(start + 2 * divSize, divSize);
    
}
int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); 
    cout.tie(0);

    int number;
    while (1) {
        cin >> number;
        if (cin.eof() == true) break;
        sizeArray = (int)pow(3, number);
        for (int x = 0; x < sizeArray; x++) {
            v.push_back("-");
        }
        run(0, sizeArray);
        for (int x = 0; x < sizeArray; x++) {
            cout << v[x];
        }
        cout << "\n";
    }
    

    return 0;
}
