# 8월 5주차 알고리즘

**1. 프로그래머스 문제** [**42747**](https://programmers.co.kr/learn/courses/30/lessons/42747)

###### **문제 설명**

H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과[1](https://programmers.co.kr/learn/courses/30/lessons/42747#fn1)에 따르면, H-Index는 다음과 같이 구합니다.

어떤 과학자가 발표한 논문 `n`편 중, `h`번 이상 인용된 논문이 `h`편 이상이고 나머지 논문이 h번 이하 인용되었다면 `h`의 최댓값이 이 과학자의 H-Index입니다.

어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.

##### **제한사항**

- 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
- 논문별 인용 횟수는 0회 이상 10,000회 이하입니다.

##### **입출력 예**

| citations       | return |
| --------------- | ------ |
| [3, 0, 6, 1, 5] | 3      |

**풀이법**

```python
for i in range(maxNum+1):
    for j in citations:
        if j >= i:
            bigger += 1
        if j <= i:
            smaller += 1
        if bigger >= i and smaller <= i:
            answer = max(answer, i)
    bigger, smaller = 0, 0
```

--------

**2. 프로그래머스 문제 [42584](https://programmers.co.kr/learn/courses/30/lessons/42584)**

###### **문제 설명**

초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

##### **제한사항**

- prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
- prices의 길이는 2 이상 100,000 이하입니다.

##### **입출력 예**

| prices          | return          |
| --------------- | --------------- |
| [1, 2, 3, 2, 3] | [4, 3, 1, 1, 0] |

**풀이법**

스택/큐 문제라고 하는데 나는 그냥 무식하게 for문 돌면서 풀었다..

```python
for corrent_index in range(len(prices)):
    for smaller_index in range(corrent_index, len(prices)):
        if prices[corrent_index] > prices[smaller_index]:
            answer.append(smaller_index - corrent_index)
            break
        elif smaller_index == len(prices)-1 and prices[corrent_index] <= prices[smaller_index]:
            answer.append(smaller_index - corrent_index)
            break
```

