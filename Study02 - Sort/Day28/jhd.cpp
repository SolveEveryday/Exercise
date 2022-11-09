
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    vector<int> v(n); //원본 벡터
    // 입력
    for (int i = 0; i < n; i++)
    {
        cin >> v[i];
    }
    // 원본 벡터를 복사하여 중복 된 수를 제거하고 정렬을 시행 할 벡터.
    vector<int> cv(v); 

    //오름차순 정렬(풀지 못하여 타인의 답안을 가져왔습니다. 제 코드는 아래에 있습니다.)
    sort(cv.begin(), cv.end()); 
    
    // 여기가 핵심입니다. 중복을 제거하고 중복된 요소를 지웁니다.
    cv.erase(unique(cv.begin(), cv.end()), cv.end());
    for (int i = 0; i < n; i++)
    {
        // i번째 요소값의 위치 it
        auto it = lower_bound(cv.begin(), cv.end(), v[i]);
        // it에서 cv벡터의 시작 주소값을 빼준 값이 답(set의 iterator는 - 연산을 지원하지 않습니다.)
        cout << it - cv.begin() << ' ';
    }

    return 0;
}

// ------- 제가 짠 코드는 시간 초과가 발생입니다. ----------------

#include<bits/stdc++.h>
using namespace std;
set<int> st;
vector<int> v;
vector<int> result;
int n, a ,c;
int main() {
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    cin >> n;
    for ( int i =0; i < n; i++ ) {
        cin >> a;
        v.push_back(a);
        st.insert(a);
    }
    cout <<"\n";
    for ( int i = 0; i < v.size(); i++ ) {
        auto x = find(st.begin(),st.end(),v[i]);
        cout << distance(st.begin(), x) << " ";
    }
}