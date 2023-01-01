#include<iostream>
using namespace std;
int arr[1001]; 
int DP[1001];
int n, result;
int main(void) {
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> arr[i];
    }

    DP[1] = 1;
    for (int i = 2; i <= n; i++) {
        int max = 0;
        for (int j = 1; j < i; j++) {
            if (arr[j] < arr[i]) {
                if (max < DP[j]) max = DP[j];
            }
        }
        DP[i] = max + 1;
    }
   
    for (int i = 1; i <= n; i++) {
        if (result < DP[i]) result = DP[i];
    }
    cout << result;
}