#include<cstdio>
int main(){
	int n, i=1;
	scanf("%d", &n);
	for(;i<=9;i++)
		printf("%d * %d = %d\n", n, i, n*i);
	return 0;
}
