# 완전탐색

## 무엇인가?

* 모든 경우의 수를 연산하여 답을 찾아내는 방법이다.
* 자물쇠 비밀번호를 000~999 전부 하는 것도 완전탐색 중 하나다.

## 어떤 문제에서 써야 하는가?

* 모든 경우의 수에 대해 연산해도 시간 제한 안에 풀 수 있을 것 같을 때
    * 이 판단이 중요!
    * 총 연산의 수가 수천만 이하여야 가능하다고 가이드라인을 잡으면 적당

## 어떻게 구현해야 하는가?

* 보통은 반복문으로 구현한다.
* 재귀가 더 효율적인 경우 재귀를 이용해 구현하기도 한다.
    * for문으로만 구현하려면 5, 6, 7, ... 수없이 많은 중첩을 해야할 것 같을 때
        * 예: 0~9 사이의 숫자 10개를 뽑는 모든 경우에 대한 문자열 표현
        * 이거 반복문으로 구현하려면 10중첩 해야한다.
    * 트리 탐색, 그래프 탐색 등은 당연히 재귀로 구현한다.
