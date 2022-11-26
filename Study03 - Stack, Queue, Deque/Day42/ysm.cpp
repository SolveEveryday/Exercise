#include <iostream>
#include <deque>
#include <string>
using namespace std;

int cnt;
int number;
int value;
int check = 1;
string function;
string sen;
deque<int> Q;

void excute() {
    if (function.length() == 0) cout << "error" << "\n";
    for (int x = 0; x < function.length(); x++) {

        if (function[x] == 'R') {
            check++;
        }

        if (function[x] == 'D') {
            if (!Q.empty() && check%2 == 0 ) {
                Q.pop_back();
            } else if (!Q.empty() && check % 2 == 1) {
                Q.pop_front();
            }
            else {
                cout << "error" << "\n";
                return;
            }
        }
    }

    cout << "[";

    if (check % 2 == 1) {
        for (int x = 0; x < Q.size(); x++) {
            cout << Q[x];
            if (x != Q.size() - 1) cout << ",";
        }
    }
    else {
        for (int x = Q.size() - 1; x >= 0; x--) {
            cout << Q[x];
            if (x != 0) cout << ",";
        }
    }
    cout << "]"<<"\n";
    Q.clear();
}
int main() {
 
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> cnt;
    while(cnt != 0 ) {
        cin >> function >> number >> sen;
        check = 1;
        string tmp;
        for (int x = 0; x < sen.length(); x++) {
            if (isdigit(sen[x])) {
                tmp += sen[x];
            }
            else {
                if (tmp != "") {
                    Q.push_back(stoi(tmp));
                    tmp = "";
                }
            }
        }
        excute();
        cnt--;
    }

    return 0;
}