#include <string>
#include <vector>
#include <algorithm>
using namespace std;
 
int solution(vector<vector<int>> routes) 
{
    int answer = 1;
    sort(routes.begin(), routes.end());
    /* 진입 지점을 기준으로 오름차순 정렬 */
 
    int Cam_Pos = routes[0][1];
    /* 가장 초기의 카메라 좌표는 Y좌표 ! */
 
    for (int i = 1; i < routes.size(); i++)
    {
        if (routes[i][1] < Cam_Pos) Cam_Pos = routes[i][1];
        /* if문은 ny < y 인 경우에 해당하는 상황. */
        /* 카메라를 새로 설치할 필요는 없고, ny로 옮겨주면 된다. */
        else if (routes[i][0] > Cam_Pos)
        {
            answer++;
            Cam_Pos = routes[i][1];
        }
        /* else-if 문은 nx > y 인 경우에 해당하는 상황. */
        /* 카메라를 반드시 새로 설치해야 한다. 설치 지점은 ny.*/
    }
    return answer;
}
