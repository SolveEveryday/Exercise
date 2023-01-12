# DFS(Depth First Seach)

트리나 그래프에서 한 루트로 탐색하다가 특정 상황에서 최대한 깊숙이 들어가서 확인한 뒤 다시 돌아가 다른 루트로 탐색하는 방식이다. 대표적으로 백트래킹에 사용한다.

시작 정점에서 간선으로 연결된 모든 정점들을 보기 때문에 브루트포스의 방법 중 하나로 알려져 있다.

관련된 알고리즘으로는 모든 정점을 확인하는건 같지만 확인하는 순서는 다른 BFS() 알고리즘이 있다.

## Graph

그래프는 vertex와 edge로 구성된 한정된 자료구조를 의미한다. vertex는 정점, edge는 정점과 정점을 연결하는 간선이다. 

## 예시

![example](https://upload.wikimedia.org/wikipedia/commons/7/7f/Depth-First-Search.gif?20090326120256)