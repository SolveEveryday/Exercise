#include<cstdio> 
#include<algorithm>
using namespace std; 
int n, k, b, temp, ret, ans;
bool broken[100001];
 
int main(){
    scanf("%d %d %d", &n, &k, &b);
    for(int i = 0; i < b; i++){
        scanf("%d", &temp); 
        broken[temp] = 1; 
    }
    for(int i = 1; i <= k; i++){
        if(broken[i])ret++; 
    }
    ans = ret; 
    for(int i = k + 1; i <= n; i++){
        if(broken[i - k]) ret--; 
        if(broken[i]) ret++; 
        ans = min(ans, ret);
    }  
    printf("%d\n", ans);
    return 0;
}