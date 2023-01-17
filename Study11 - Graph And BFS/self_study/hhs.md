# BFS(Breadth First Seach)

트리나 그래프에서 한 정점에서 그 주변 정점으로 퍼져 탐색하는 기법.

DFS와 마찬가지로 시작 정점에서 간선으로 연결된 모든 정점들을 보기 때문에 브루트포스의 방법 중 하나로 알려져 있다.

접근하는 순서만 다를 뿐 결과는 DFS와 동일하다.

## 구현 방법

큐를 이용한다.

시작 정점을 기준으로 간선에 연결된 주변 정점들을 큐에 넣는다.

이 과정을 큐가 빌때까지 반복한다.

## 예시

![example](https://upload.wikimedia.org/wikipedia/commons/5/5d/Breadth-First-Search-Algorithm.gif?20100504223639)