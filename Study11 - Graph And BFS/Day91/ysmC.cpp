#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;


int main() {
    
    long long start, result;
    cin >> start >> result;
    int cnt = 1;
    while (start != result) {
        
        if (start > result) {
            cnt = -1;
            break;
        }

    

        if (result % 2 == 0L) {
            result /= 2;
            cnt++;
            continue;
        }

        if (result % 10 == 1L) {
            result /= 10;
            cnt++;
            continue;
        }
        
        cnt = -1;
        break;
        
        
    }

    cout << cnt;
    return 0;
}