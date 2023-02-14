#include <stdio.h>
#include <iostream>
#include <vector>
#include <queue>
using namespace std;
 
vector<pair<int, int>> graph[20010];
int d[20010];
int V, E, start;
 
void dijkstra(int start)
{
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({0, start});
    d[start] = 0;
    
    while(!pq.empty())
    {
        int now = pq.top().second;
        int nowCost = pq.top().first;
        pq.pop();
        
        if(nowCost != d[now])
        {
            continue;    
        }
        
        for(int i = 0; i < graph[now].size(); i++)
        {
            int next = graph[now][i].first;
            int nextCost = graph[now][i].second;
            
            if(nowCost+nextCost < d[next])
            {
                d[next] = nowCost+nextCost;
                pq.push({d[next], next});
            }
        }
    }
}
 
int main(void)
{

    
    cin >> V >> E >> start;
    
    for(int i = 1; i <= V; i++)
    {
        d[i] = 9999999;
    }
 
    for(int i = 1; i <= E; i++)
    {
        int from, to, weight;
        cin >> from >> to >> weight;
        
        graph[from].push_back({to, weight});
    }
    
    dijkstra(start);
    
    for(int i = 1; i <= V; i++)
    {
        if(d[i] == 9999999)
        {
            cout << "INF" << "\n";    
        }
        else
        {
            cout << d[i] << "\n";        
        }
    }
    
    return 0;
}
