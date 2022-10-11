#include <iostream>
using namespace std;

typedef long long ll;
int main() {
	ll w, h, f, c, x1, y1, x2, y2;
	cin >> w >> h >> f >> c >> x1 >> y1 >> x2 >> y2;
	ll area = (x2 - x1) * (y2 - y1) * (c+1);
	if (f <= w / 2) { 
		if (f <= x1) { 
			cout << w*h - area;
		}
		else { 
			cout << w * h - (area + (min(f, x2) - x1) * (y2 - y1) * (c+1));
		}
	} 
	else { 
		if (w <= x1 + f) { 
			cout << w * h - area;
		}
		else { 
			cout << w * h - (area + (min(w, f + x2) - (f + x1)) * (y2 - y1) * (c+1));
		}
	}
}

