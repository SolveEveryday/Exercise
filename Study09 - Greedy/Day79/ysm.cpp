#include <iostream>
#include <algorithm>
#include <bits/stdc++.h>
using namespace std;

int main() {

    char input[51];
    char alphabat[26] = { 0 };
    string sen, tmp;
    int middle = -1;
    
    cin >> input;
    int len = strlen(input);
    int cnt = 0;
    int flag = 0;
    
    
    for (int x = 0; x < len; x++) {
        alphabat[input[x] - 'A']++;
    }
    
    if (len % 2 == 0) {
        for (int x = 0; x < 26; x++) {
            if (alphabat[x] % 2 != 0) {
                flag = 1;
                break;
            }
        }
    }
    else {
        for (int x = 0; x < 26; x++) {
            if (alphabat[x] % 2 != 0) {
                cnt++;
                alphabat[x]--;
                middle = x;
            }
        }

        if (cnt > 1) flag = 1;
    }

    if (flag == 1) {
        cout << "I'm Sorry Hansoo";
    }
    else {
        for (int y = 0; y < 26; y++) {
            if (alphabat[y] != 0) {
                for (int x = 0; x < alphabat[y] / 2; x++) {
                    sen += 'A' + y;
                }
            }
        }

        tmp = sen;
        reverse(tmp.begin(), tmp.end());
        if (middle != -1) sen += 'A' + middle;
        sen += tmp;

        cout << sen;
    }



    return 0;
}


