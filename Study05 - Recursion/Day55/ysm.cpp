#include <string>
#include <vector>
#include <iostream>
using namespace std;

string fun(string w) {
	string u, v;

	if (w == "") return "";

	for (int acnt = 0,bcnt=0, i = 0; i < w.size(); i++) {
		if (w[i] == '(') acnt++;
		else bcnt++;
		if (acnt == bcnt) {
			u = w.substr(0,i+1);
			v = w.substr(i + 1);
			break;
		}
	}

	
	int cnt = 0;
	for (int i = 0; i < u.size(); i++){
		if (cnt==0 && u[i] == ')') {
			cnt++;
			continue;
		}
		if (u[i] == '(') cnt++;
		else cnt--;
	}

	if (cnt == 0) {
	    v = fun(v);
	
		return u + v;
	}


	else {
		string tmp = "("; 
		tmp += fun(v); 
		tmp += ")"; 
		u.erase(0,1); 
		u.erase(u.size()-1,1);
		for (int i = 0; i < u.size(); i++) {
			if (u[i] == '(') u[i] = ')';
			else u[i] = '(';
		}
		return tmp + u; //4.5
	}
}

string solution(string p) {
	string answer = "";
	answer = fun(p);
	return answer;
}

int main()
{
	cout << solution(")(") << endl;
	cout << solution("(()())()") << endl;
	cout << solution("()))((()");
}
