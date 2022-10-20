#include <iostream>
#include <stdio.h>
#include <cstring>
using namespace std;

int main() {
   
    int amount;
    string serialNumber[51];

    cin >> amount;

    for (int x = 0; x < amount; x++) {
        cin >> serialNumber[x];
    }

    
    for (int y = 0; y < amount; y++) {

        int shortLength = 51;
        int shortIndex = 0;
        string tmp = " ";

        for (int x = y; x < amount; x++) {
            if (serialNumber[x].length() < shortLength) {
                shortLength = serialNumber[x].length();
                shortIndex = x;
            }
        }
        tmp = serialNumber[y];
        serialNumber[y] = serialNumber[shortIndex];
        serialNumber[shortIndex] = tmp;
        
    }

    for (int y = 0; y < amount-1; y++) {
        for (int x = y+1; x < amount; x++) {
            int sum1 = 0;
            int sum2 = 0;
            string tmp = " ";

            if (serialNumber[y].length() == serialNumber[x].length()) {
                for (int z = 0; z < serialNumber[y].length(); z++) {
                    if (serialNumber[y][z] >= 48 && serialNumber[y][z] <= 57) {
                        int result1 = int(serialNumber[y][z]);
                        sum1 += (result1 - 48);
                    }
                }

                for (int z = 0; z < serialNumber[x].length(); z++) {
                    if (serialNumber[x][z] >= 48 && serialNumber[x][z] <= 57) {
                        int result2 = int(serialNumber[x][z]);
                        sum2 += (result2 - 48);
                    }
                }

                if (sum1 > sum2) {
                    tmp = serialNumber[y];
                    serialNumber[y] = serialNumber[x];
                    serialNumber[x] = tmp;
                }

                if (sum1 == sum2) {
                    for (int z = 0; z < serialNumber[y].length(); z++) {
                        if (serialNumber[y][z] > serialNumber[x][z]) {
                            tmp = serialNumber[y];
                            serialNumber[y] = serialNumber[x];
                            serialNumber[x] = tmp;
                            break;
                        }
                        else if (serialNumber[y][z] < serialNumber[x][z]) {
                            break;
                        }
                    }
                }
            }
        }
    }

    for (int x = 0; x < amount; x++) {
        cout << serialNumber[x] << '\n';
    }

    return 0;
}


