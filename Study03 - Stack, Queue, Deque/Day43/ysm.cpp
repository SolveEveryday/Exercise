#include<iostream>
#include<cmath>
#include<deque>
#include<sstream>

using namespace std;

int priority(char f, char b) { 
	if (f == '*' || f == '/') {
		if (b == '*' || b == '/') {
			return 0;
		}
		else return -1;
	}
	else {
		if (b == '*' || b == '/') {
			return 1;
		}
		else return 0;
	}
}

long long calculation(long long a, long long b, char p) {
	if (p == '-') {
		return a - b;
	}
	if (p == '+') {
		return a + b;
	}
	if (p == '/') {
		return a / b;
	}
	if (p == '*') {
		return a * b;
	}
}


int main() {
	string str;
	cin >> str;

	deque<char> oper;
	deque<long long> num;

	long long n = 0;

	for (int i = 0; i < str.size(); i++) {
		if (str[i] < 48 || str[i]>57) {
			oper.push_back(str[i]);
			if (i != 0) {
				num.push_back(n);
				n = 0;
			}
		}
		else {
			n *= 10;
			n += str[i] - 48;
		}
	}
	num.push_back(n);

	if (oper.size() == num.size()) {
		n = num.front();
		n = n * (-1);
		num.pop_front();
		oper.pop_front();
		num.push_front(n);
	}

	while (oper.size() > 1) {

		int p = priority(oper.front(), oper.back());
		long long f, b, fresult, bresult;

		f = num.front();
		num.pop_front();
		fresult = calculation(f, num.front(), oper.front());

		b = num.back();
		num.pop_back();
		bresult = calculation(num.back(), b, oper.back());

		if (p == 0) {
			if (fresult < bresult) {
				p = 1;
			}
			else {
				p = -1;
			}
		}

		if (p == -1) {
			num.push_back(b);
			num.pop_front();
			num.push_front(fresult);
			oper.pop_front();
		}
		else if (p == 1) {
			num.push_front(f);
			num.pop_back();
			num.push_back(bresult);
			oper.pop_back();

		}

	}

	if (oper.size() == 1) {
		long long n1 = num.front();
		num.pop_front();
		long long n2 = num.front();
		num.pop_front();
		num.push_front(calculation(n1, n2, oper.front()));
		oper.pop_front();
	}


	cout << num.front();


}