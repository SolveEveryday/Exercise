#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    
	int cardAmount;
	int card[20000001] = { 0 };
	int numberAmount;
	int n;

	cin >> cardAmount;
	for (int x = 0; x < cardAmount; x++) {
		cin >> n;
		card[n + 10000000]++;
	}

	cin >> numberAmount;
	int a;
	
	for (int x = 0; x < numberAmount; x++) {
		cin >> a;
		if (card[a + 10000000] > 0) cout << "1 ";
		else cout << "0 ";
	}

	return 0;
}