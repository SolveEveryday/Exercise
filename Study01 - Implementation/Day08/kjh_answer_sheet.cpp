#include <iostream>
using namespace std;

typedef long long ll;
int main() {
	ll w, h, f, c, x1, y1, x2, y2;
	cin >> w >> h >> f >> c >> x1 >> y1 >> x2 >> y2;
	ll area = (x2 - x1) * (y2 - y1) * (c+1);
	if (f <= w / 2) { //왼쪽 크기 <= 오른쪽 크기
		if (f <= x1) { //왼쪽 영향 X
			cout << w*h - area;
		}
		else { //왼쪽 영향 받음
			cout << w * h - (area + (min(f, x2) - x1) * (y2 - y1) * (c+1));
		}
	} 
	else { //왼쪽 크기 > 오른쪽 크기
		if (w <= x1 + f) { //오른쪽 영향 X
			cout << w * h - area;
		}
		else { //오른쪽 영향 받음
			cout << w * h - (area + (min(w, f + x2) - (f + x1)) * (y2 - y1) * (c+1));
		}
	}
}