# 재귀함수
- 진정한 self-invocation의 정수 : 함수 내부에서 자신을 스스로 호출하는 구조.

### 장점
1. 코드 가독성이 좋아진다. 단, 코드가 익숙하지 않은 사람이 보면 이 장점은 단점이된다.

### 주의사항
1. 재귀함수는 자료구조 자체를 Thread의 저장공간인 Call Stack을 이용한다. 하나의 Thread의 stack 공간은 1MB이다. 따라서 너무 많은 호출이 발생하면 stack의 메모리공간을 초과하는
Stack Overflow가  발생할 수 있다. 따라서 호출 횟수를 잘 설정하는 것이 좋다.
2. 반복을 끝내기 위한 종료조건을 무조건 작성해야한다. 그렇지 않으면 위의 overflow가 발생하게 된다.
3. 속도는 반복문이 좋기 때문에 N개의 포문이 중복될 경우 가독성면에서 재귀를 사용하는 것이 이점이 될 수 있다.
4. 재귀를 공부할때는 디버깅을 사용하여 하나의 메서드마다 반환하는 값을 확인하는 방식으로 진행해야한다.
