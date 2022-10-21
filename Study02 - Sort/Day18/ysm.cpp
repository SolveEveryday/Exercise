#include <iostream>
#include <stdio.h>
using namespace std;

struct Num {
    int value;
    int idx;
};

int amount;
Num input[500001];
Num copyArray[500001];
int result;

void merge(int start, int end) {
    
    int mid = (start + end) / 2;
    int x = start;
    int y = mid + 1;
    int z = start;

    while (x <= mid && y <= end) {
        if (input[x].value <= input[y].value) {
            copyArray[z++] = input[x++];
        }
        else {
            copyArray[z++] = input[y++];
        }
    }

    if (x <= mid) {
        int n = x;
        while (n <= mid) {
            copyArray[z++] = input[n++];
        }
    }
    else {
        int n = y;
        while (n <= end) {
            copyArray[z++] = input[n++];
        }
    }

    for (int m = start; m <= end; m++) {
        input[m] = copyArray[m];
    }
}

void mergeSort(int start, int end) {
    if (start < end) {
        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        merge(start, end);
    }
}

int main() {
   
    cin >> amount;
    
    for (int x = 0; x < amount; x++) {
        cin >> input[x].value;
        input[x].idx = x;
    }

    mergeSort(0, amount - 1);
    result = 0;

    for (int x = 0; x < amount; x++) {
        if (result < input[x].idx - x) {
            result = input[x].idx - x;
        }
    }

    cout << result + 1;
    return 0;
}


