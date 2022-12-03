#include <iostream>
#include <string>
using namespace std;

int number; 

string first = "\"재귀함수가 뭔가요?\"\n";
string second = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
string third = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
string fourth = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
string endStr = "라고 답변하였지.\n";

string repeat[51][250];

void barCheck(string str, int level) {
    for (int x = 0; x < level; x++) cout << "____";
    cout << str;
}
void run(int level) {
 
    barCheck(first, level);

    if (level == number) {
        barCheck("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n",level);
        barCheck(endStr, level);
        return;
    }

    barCheck(second, level);
    barCheck(third, level);
    barCheck(fourth, level);

    run(level + 1);
    barCheck(endStr, level);
    
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> number;
    cout << "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
    run(0);

    return 0;
}