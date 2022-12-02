# 재귀(Recursion) 함수

![예시](https://upload.wikimedia.org/wikipedia/commons/thumb/b/b3/Screenshot_Recursion_via_vlc.png/1200px-Screenshot_Recursion_via_vlc.png)

위 사진은 재귀를 사진으로 표현한 예시

하나의 함수에서 자신을 다시 호출하여 작업을 수행하는 방식으로 주어진 문제를 푸는 방법이다. 재귀 호출이나 되부름이라고도 한다.

## 예시

```java
public static void printHyunSoo(int number) {
    System.out.println("현수 " + number++);
    printHyunSoo(number);
}

public static void main(String[] args) {
    printHyunSoo(1);
}

/*
현수 1
현수 2
현수 3
현수 3
....
*/
```

## 주의할 점

재귀함수는 자기 자신을 계속해서 호출하기 때문에 스택 메모리가 계속해서 증가하다가 멈추지 않으면 StackOverFlow가 발생한다.

~~스택오버플로우 사이트에 질문이 계속 추가되니까 이름이 그렇게 된게 아닐까?.~~

따라서 조건을 지정해서 재귀를 멈추는 것이 중요하다.

### 조건 예시

```java
public static void printHyunSoo(int number) {
    // number가 100이 넘어가면 이 함수는 멈춘다.
    if (number >= 100) return;
    System.out.println("현수 " + number++);
    printHyunSoo(number);
}
```

재귀 함수를 이용하면 코드를 많이 안쓸 수 있지만 실무에서는 권장하지 않는 방법이다.

~~쓰다가 사수한테 맞을 수도 있다.~~