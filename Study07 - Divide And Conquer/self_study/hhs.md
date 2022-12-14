# 분할 정복

분할 정복(Divide and Conquer)은 여러 알고리즘의 기본이 되는 해결방법으로, 기본적으로는 엄청나게 크고 방대한 문제를 조금씩 조금씩 나눠가면서 용이하게 풀 수 있는 문제 단위로 나눈 다음 그것들을 다시 합쳐서 해결하자는 개념에서 출발하였다.

![예시](https://w.namu.la/s/739414961f779b823a01f6ee005d0b88b4c360bc903b2a6c1d8cc066766f939d322d860e204f587cff859e02a70941b07ba50f66ed5c39efba6d3071db2aa6f1dacf1b288502b0443dec9b14da84260390a4c6ed9ae42b9244f867e44d501725d4002535d5b19d038b626dc5d523e294)

분할 정복은 위 그림과 같이 크게 세가지 단계로 나뉜다.

* 분할: 문제를 더이상 분할할 수 없을 때까지 동일한 유형의 여러 하위 문제로 나눈다.
* 정복: 가장 작은 단위의 하위 문제를 해결하여 정복한다.
* 조합: 하위 문제에 대한 결과를 원래 문제에 대한 결과로 조합한다.

## 예시 알고리즘

* 퀵소트
* 병합정렬
* 고속 푸리에 변환