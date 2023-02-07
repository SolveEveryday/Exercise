# 누적합
## 누적합이란?
* 부분합을 구하기 위해 어떤 수열에 대한 누적합을 저장해놓은 배열

![image](https://user-images.githubusercontent.com/82758364/216969381-65f82049-a6b5-4ee3-9907-3b4efb2eaa95.png)

## 어떻게 사용?
1. 미리 구간합 배열을 전처리 과정에서 계산해 놓음.
2.  맨 처음에 Prefix Sum 배열에 0을 삽입하고 그 다음 요소부터는
    Prefix Sum[i] = Prefix Sum[i - 1] + Original Array[i]로 나타낼 수 있기 때문에
    Prefix Sum 배열의 값을 채우는 코드는 O(N) 내에 전처리가 수행될 수 있다.
3. 구간합을 구하고자 하는 경우
    Prefix Sum 배열의 i번째 요소와 j번째 요소의 차이는
    Original Array[i] ~ Original Array[j]까지의 구간합을 의미한다.
    따라서 구간합을 구하는 코드는 O(1) 내에 수행될 수 있다.

## 시간 복잡도
* 전처리 단계 
  * 1차원 : O(N)
  * 2차원 : O(N*M)
* 계산 : O(1)

## 주의 사항
* Original 배열의 i번째 요소가 변경되는 경우 Prefix Sum 배열의 i + 1번째 ~ N - 1번째 요소가 모두 업데이트되어야 한다는 단점이 있다.
* 따라서 Prefix Sum은 값을 변경하지 않는 경우(immutable)에 효율적인 알고리즘이다.