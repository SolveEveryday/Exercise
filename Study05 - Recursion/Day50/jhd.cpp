#include <bits/stdc++.h>
using namespace std;
int a, b, cnt, p_cnt;

void print(){
    for (int i = 0 ; i < p_cnt; i++) {
        cout << "_";
    }
}

void func(int stop__){
    print();
    cout  << "\"재귀함수가 뭔가요?\"\n";

    if(stop__ == 0){
        print();
        cout << "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
        return;
    }
    print();
    cout << "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
    print();
    cout << "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"; 
    print();
    cout << "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
    p_cnt +=4;
    func(stop__ - 1);

    print();
    cout << "라고 답변하였지.\n";
    p_cnt -= 4;
}


int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    cin >> cnt;
    cout << "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
    func(cnt);
    cout << "라고 답변하였지.\n";
}