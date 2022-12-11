#include <iostream>
#include <cmath>
using namespace std;
int n, r, c;
int ans = 0;
void dc(int x, int y, int size){
    if(c==x && r==y){ 
        cout << ans;
        return;
    }
    else if (c < x + size && r < y + size && c >= x && r >= y){

        dc(x, y, size / 2);
        dc(x + size / 2, y, size / 2);
        dc(x, y + size / 2, size / 2);
        dc(x + size / 2, y + size / 2, size / 2);
    }else{ 
        ans += size * size;
    }
}
int main(){
    cin >> n >> r >> c;
    dc(0, 0, pow(2, n));
    return 0;
}
