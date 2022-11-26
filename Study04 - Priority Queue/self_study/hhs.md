# 우선순위 큐 정리

# 우선순위 큐(Priority queue)

우선순위 큐는 큐와 다르게 먼저 들어오는 데이터가 아니라 우선순위가 높은 데이터가 먼저나가는 형태의 자료구조 이다.

우선순위 큐는 힙으로 구현을 한다.

# 힙

완전이진트리 형태의 자료구조이며 여러 개의 값중 최댓값 혹은 최솟값을 찾는 속도가 빠르다.

대개로 배열 형태로 구현을 한다.

## 힙의 특징

- **완전이진트리** 형태로 이루어져 있다.
- 부모노드와 서브트리간 대소 관계가 성립된다. (반정렬 상태)
- 이진탐색트리(BST)와 달리 중복된 값이 허용된다.

## 힙의 종류

- 최대 힙 - 부모 노드가 자식 노드보다 크거나 같다. → root는 요소들중 가장 큼
- 최소 힙 - 부모 노드가 자식 노드보다 작거나 같다. → root는 요소들중 가장 작음

## 힙의 과정

예시는 최소힙이다.

### 삽입

![https://blog.kakaocdn.net/dn/b1bSHH/btqBzjdlAZ1/VrIwIsaCbBdz6PpfCQE4Qk/img.gif](https://blog.kakaocdn.net/dn/b1bSHH/btqBzjdlAZ1/VrIwIsaCbBdz6PpfCQE4Qk/img.gif)

맨 뒤에 요소를 채우고 부모를 재귀적으로 비교하고 변경하면서 최소힙 조건을 맞춘다.

### 삭제

![https://blog.kakaocdn.net/dn/cuQPP8/btqByFt8Nao/RvfM45MGdfLwXw6n5otChk/img.gif](https://blog.kakaocdn.net/dn/cuQPP8/btqByFt8Nao/RvfM45MGdfLwXw6n5otChk/img.gif)

root를 먼저 삭제하고 맨 뒤에있는 요소를 root로 변경한다. 그리고 재귀적으로 자식들을 비교하고 변경하면서 최소힙 조건을 맞춘다.

## 힙 == 우선순위 큐 ← ?

정답은 아니다.

힙은 우선순위 큐에서 정렬을 도와주는 자료구조지 그 자체는 아니다.

추상화를 하면 힙은 이진 트리형태이고 우선순위 큐는 우리가 생각하는 일차원 적으로 정렬된 큐라고 생각하면된다.