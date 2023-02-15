# 최단 경로

최단경로 알고리즘은 여러가지가 있다.

1.  **BFS (완전탐색 알고리즘)**
    - 가중치가 없거나 모든 가중치가 동일한 그래프에서 최단경로를 구하는 경우 가장 빠르다
2. **다익스트라 알고리즘 (Dijkstra Algorithm)**
    - 음이 아닌 가중 그래프에서의 단일 쌍, 단일 출발, 단일 도착 최단 경로 문제
3. **벨만-포드 알고리즘 (Bellman-Ford-Moore Algorithm)**
    - 가중 그래프에서의 단일 쌍, 단일 출발, 단일 도착 최단 경로 문제
4. **플로이드-워셜 알고리즘 (Floyd-Warshall Algorithm)**
    - 전체 쌍 최단 경로 문제

## 📌다익스트라

**간단한 버전**

- 그래프에 여러 노드가 있을 때, 특정한 노드에서 출발하여 다른 노드로 가는 각각의 최단 경로를 구해주는 알고리즘
- **음의 간선**(0보다 작은 값을 가지는 간선)이 없어야 정상적으로 동작
    - 각 정점을 최대 한 번씩만 방문하여 최단 거리를 확정한다. (음의 가중치를 가질 수 없다.)
- 아직 방문하지 않은 정점들 중 최단거리인 점을 찾아 방문하여 최단거리를 확정하고, 이를 반복하는 방식 → O(V^2)의 시간복잡도

**개선된 알고리즘 단계**

- 방문하지 않은 정점 중에서 최단 거리가 최소인 정점을 찾는 과정에서 우선순위 큐 혹은 힙 자료구조를 이용하면 더욱 개선된 알고리즘이 가능하다. → 시간 복잡도는 O(ElogV)

## 📌**벨만-포드 알고리즘**

- **음의 가중치를 지닌 간선이 존재해도 사용할 수 있다**
    
    음의 가중치를 가진 방향 그래프를 주면서 최단 거리를 구하라고 한다면 다익스트라 알고리즘이 아닌 벨만 포드 알고리즘을 사용해야 합니다.
    

## 📌****플로이드-워셜 알고리즘****

- V개의 정점과 E개의 간선을 가진 가중 그래프 G에서 모든 정점 사이의 최단 경로를 구하는 알고리즘
- 각 단계마다 **특정한 노드 k를 거쳐 가는 경우를 확인**합니다.
    - a에서 b로 가는 최단 거리보다 a에서 k를 거쳐 b로 가는 거리가 더 짧은지 검사합니다.
- 시간 복잡도는 **O(N^3)**