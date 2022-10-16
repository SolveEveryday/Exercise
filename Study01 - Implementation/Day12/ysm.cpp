#include <string>
#include <vector>
#include <map>

using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    int score[8] = {0,3,2,1,0,1,2,3};
    map<char,int> output;
    
    for(int x = 0;x<survey.size();x++) {
        output[survey[x][choices[x]/4]] += score[choices[x]];
    }
    
    answer += output['R'] >= output['T'] ? "R":"T";
    answer += output['C'] >= output['F'] ? "C":"F";
    answer += output['J'] >= output['M'] ? "J":"M";
    answer += output['A'] >= output['N'] ? "A":"N";
    return answer;
}