#include <iostream>
using namespace std;

int main() {
	int photoSize, recommend;
	cin >> photoSize >> recommend;
	int cnt_recommend[101] = { 0 };
	int when_recommend[101] = { 0 };
	int student;
	int usePhoto = 0;


	for (int x = 1; x <= recommend; x++) {
		cin >> student;
		if (cnt_recommend[student] > 0) cnt_recommend[student]++;
		else {
			//사진틀이 비어있을때
			if (usePhoto < photoSize) {
				cnt_recommend[student]++;
				usePhoto++;
				when_recommend[student] = x;
			}
			//사진틀이 꽉차면
			else {
				//가장 추천 횟수가 적은 학생 찾기
				int changedStudent;
				int min = 1200;
				for (int y = 1; y <= 100; y++) {
					if (cnt_recommend[y] == 0) continue;
					if (cnt_recommend[y] < min) {
						min = cnt_recommend[y];
						changedStudent = y;
					} else if (cnt_recommend[y] == min) {
						if (when_recommend[changedStudent] > when_recommend[y]) {
							changedStudent = y;
						}
					}
				}
				cnt_recommend[student]++;
				when_recommend[student] = x;
				cnt_recommend[changedStudent] = 0;
				when_recommend[changedStudent] = 0;

			}
		}
	}

	for (int x = 0; x < 100; x++) {
		if (when_recommend[x] != 0) cout << x << " ";
	}

	return 0;
}