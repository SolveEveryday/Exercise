#include <iostream>
using namespace std;

int a, b, c;
int year = 0;
int E = 0;
int S = 0;
int M = 0;
void run() {
    while (1) {
        E++;
        S++;
        M++;
        if (E > 15) {
            E = 1;
        }

        if (S > 28) {
            S = 1;
        }

        if (M > 19) {
            M = 1;
        }
        year++;
        if (E == a && S == b && M == c) {
            cout << year;
            return;
        }
    }
}
int main() {
   
    cin >> a >> b >> c;
    run();

    return 0;
}
