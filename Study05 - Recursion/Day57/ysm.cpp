#include <string>
#include <vector>

using namespace std;

string name = "AEIOU";
int cnt = 0;
string path;
int answer = 0;

void run(int level, string word) {
    
    if (path == word) {
        answer = cnt;
        return;
    }

    cnt++;
 
    if (level == 5) {
        return ;
    }
    for (int x = 0; x < 5; x++) {
        
        path += name[x];
        run(level + 1, word);
        path = path.substr(0, path.size() - 1);
    }
}

int solution(string word) {
    
    run(0, word);
    return answer;
}