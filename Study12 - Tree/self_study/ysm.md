# 알고리즘 스터디 12 - 트리

# 트리

트리는 **어떤 노드들의 집합으로 노드들은 각 서로 다른 자식을 가지며 이때 각 노드는 재사용 되지 않는 구조이다.**

- 트리에서 루트에서 어떤 노드로 가는 경로는 유일하다. 또한 임의의 두 노드 간의 경로도 유일하다.
- 트리의 재귀적 속성에서 중요한 포인트: 모든 트리는 루트와 루트 밑에 있는 서브트리의 집합이다.

![Untitled](%E1%84%8B%E1%85%A1%E1%86%AF%E1%84%80%E1%85%A9%E1%84%85%E1%85%B5%E1%84%8C%E1%85%B3%E1%86%B7%20%E1%84%89%E1%85%B3%E1%84%90%E1%85%A5%E1%84%83%E1%85%B5%2012%20-%20%E1%84%90%E1%85%B3%E1%84%85%E1%85%B5%20f67922d1d88b46e399d375346f07fc3e/Untitled.png)

### 트리의 특징

- 그래프의 한 종류
    - DAG(Directed Acyclic Graphs, 방향성이 있는 비순환 그래프)의 한 종류
        - 사이클이 없다.
- 계층 모델이다.
- 노드가 N개의 트리는 항상 N-1개의 엣지를 가진다.
- 두개의 정점 사이에 반드시 1개의 경로만을 가진다.
- 한개의 루트 노드만이 존재하며 모든 자식 노드는 한개의 부모 노드만을 가진다.
    - 부모-자식 관계이므로 흐름은 top-bottom 아니면 bottom-top으로 이루어진다.
- 순회는 Pre-order, In-order, Post-order로 이루어진다.

### 트리의 종류

### 이진 트리(binary-tree) vs 이진 트리가 아닌 트리(non-binary-tree)

1. **이진 트리가 아닌 트리 Non-binary-tree**
    - 노드의 자식 개수에 대한 제한이 없는 트리
    - 대표적인 예: **트라이(trie)**
2. **이진 트리 Binary-tree**
    - 노드의 자식 개수가 2개 이하인 트리
    - 이진 트리 순회
        - 중위 순회(in-order traversal): 왼쪽 가지 -> 현재 노드 -> 오른쪽 가지
        - 전위 순회(pre-order traversal): 현재 노드 -> 왼쪽 가지 -> 오른쪽 가지
        - 후위 순회(post-order traversal): 왼쪽 가지 -> 오른쪽 가지 -> 현재 노드
    - **이진 검색 트리 Binary-search-tree (BST)**
        
        ![https://blog.kakaocdn.net/dn/LX2FQ/btq9JNeuiXw/kaKByuDIrNfcniXehWuYvk/img.png](https://blog.kakaocdn.net/dn/LX2FQ/btq9JNeuiXw/kaKByuDIrNfcniXehWuYvk/img.png)
        
        - 각 노드는 left subtree와 right subtree의 루트를 자식으로 가지며 이때 왼쪽 서브트리는 자신보다 작은 값을 오른쪽 서브트리는 자신보다 큰 값을 가진다.
        - 자료 입력, 삭제, 탐색 모두 시간복잡도가 O(log N) 이다.
    - BST에서 만약 주어진 데이터셋이 증가수열의 형태라고 생각해보자. 1-2-3-4... 이와 같이 길게 늘어진 형태가 되서 탐색에 걸리는 시간도 O(N)이 된다. 만약에 이렇게 길게 늘어진 트리의 중간에 있는 노드를 루트로 잡고 접는다면? 그럼 시간복잡도가 O(log N)이 됨을 알 수 있다. 이렇게 표현하는 방식이 바로 아래의 균형 이진 탐색 트리이다.
        
        ![https://blog.kakaocdn.net/dn/X0QIH/btq9MEPoWpJ/dHaewQnPyRKNkHYkbSKgqK/img.png](https://blog.kakaocdn.net/dn/X0QIH/btq9MEPoWpJ/dHaewQnPyRKNkHYkbSKgqK/img.png)
        
    - **균형 이진 탐색 트리 Balanced binary search tree**
        - O(logN) 시간에 삽입과 탐색을 할 수 있을 정도로 균형이 잘 잡혀 있는 경우
        - EX) Splay tree, AVL tree, **[RedBlack tree](https://simsim231.tistory.com/168)**
            
            ![https://blog.kakaocdn.net/dn/bEHNaY/btq9O74cLbw/DKSBC1zsFNM1Hmaw9seHM0/img.png](https://blog.kakaocdn.net/dn/bEHNaY/btq9O74cLbw/DKSBC1zsFNM1Hmaw9seHM0/img.png)
            
    - **완전 이진 트리 Complete Binary Tree**
        - 트리의 모든 높이에서 노드가 꽉 차 있는(2개가 모두 있는) 이진 트리. 즉, 마지막 레벨을 제외하고 모든 레벨이 완전히 채워져 있다.
        - 마지막 레벨은 꽉 차 있지 않아도 되지만 노드가 왼쪽에서 오른쪽으로 채워져야 한다.
        - 마지막 레벨 h에서 (1 ~ 2h-1)개의 노드를 가질 수 있다.
        - 배열을 사용해 효율적으로 표현 가능
    - **전 이진 트리 Full Binary Tree**
        - 모든 노드가 0개 또는 2개의 자식 노드를 갖는 트리
    - **포화 이진 트리 Perfect Binary Tree**
        - 전 이진 트리이면서 완전 이진 트리인 경우
        - 모든 말단 노드는 같은 높이에 잇어야 하며, 마지막 단계에서 노드의 개수가 최대가 되어야 한다.
        - 모든 내부 노드가 두 개의 자식 노드를 가진다.
        - 모든 말단 노드가 동일한 깊이 또는 레벨을 갖는다.
        - 노드는 개수는 2^(k-1)개 이다. (k: 트리의 높이)