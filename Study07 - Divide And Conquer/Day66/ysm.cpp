#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int arr[1024][1024];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); 
    cout.tie(0);

    int size;
    cin >> size;

    for (int y = 0; y < size; y++) {
      for (int x = 0; x < size; x++) {
          cin >> arr[y][x];
      }
    }
   
    while (size != 1) {
        vector<vector<int>> tmp(size / 2, vector<int>(size / 2, 0));

        for (int y = 0; y < size; y += 2) {
            for (int x = 0; x < size; x += 2) {
                vector<int> tmpV(4);
                tmpV[0] = arr[y][x];
                tmpV[1] = arr[y + 1][x];
                tmpV[2] = arr[y][x+1];
                tmpV[3] = arr[y+1][x+1];

                sort(tmpV.begin(), tmpV.end());

                tmp[y / 2][y / 2] = tmpV[2];
            }
        }

        size /= 2;

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                arr[y][x] = tmp[y][x];
            }
        }

    }

    cout << arr[0][0] << "\n";

    return 0;
}
