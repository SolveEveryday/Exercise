using namespace std;
int find(int& w, int& h) {
    int k;
    
    while(h != 0) {
        k = w%h;
        w = h;
        h = k;
    }
    
    return w;
}
long long solution(int w,int h) {
    long long answer = 1;
    answer = (long long)w * (long long)h - (w+h-find(w,h)); 
    return answer;
}