# 8월 둘째주 (4일 ~ 9일) 알고리즘

**1. 프로그래머스 문제** [**42628**](https://programmers.co.kr/learn/courses/30/lessons/42628)

###### **문제 설명**

이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.

| 명령어 | 수신 탑(높이)                  |
| ------ | ------------------------------ |
| I 숫자 | 큐에 주어진 숫자를 삽입합니다. |
| D 1    | 큐에서 최댓값을 삭제합니다.    |
| D -1   | 큐에서 최솟값을 삭제합니다.    |

이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.

##### **제한사항**

- operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
- operations의 원소는 큐가 수행할 연산을 나타냅니다.
  - 원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
- 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.

##### **입출력 예**

| operations          | return |
| ------------------- | ------ |
| [I 16,D 1]          | [0,0]  |
| [I 7,I 5,I -5,D -1] | [7,5]  |

**풀이법**

무난하게 풀었다 !

queue라는 list를 하나 만든 후 거기에 값을 append하고 remove 했다.

조건에 맞춰서 if 조건을 만들어줬다.

```python
    for op in operations:
        if op[0] == "I":
            queue.append(int(op[2:]))
        elif len(queue) != 0 and op == "D 1":
            queue.remove(max(queue))
        elif len(queue) != 0 and op == "D -1":
            queue.remove(min(queue))
```

-----

**2. 프로그래머스 문제 42842**

###### **문제 설명**

Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.

![carpet.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/b1ebb809-f333-4df2-bc81-02682900dc2d/carpet.png)

Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.

Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.

##### **제한사항**

- 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
- 노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
- 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.

##### **입출력 예**

| brown | yellow | return |
| ----- | ------ | ------ |
| 10    | 2      | [4, 3] |
| 8     | 1      | [3, 3] |
| 24    | 24     | [8, 6] |

**풀이법**

yellow 값을 소인수분해하는 divisor 함수를 만들어서 풀었다.

divisor 함수는 num의 인수들을 짝으로 배열에 저장해서 리턴해주는 함수이다.

그 후 solution 함수에서는 소인수분해한 배열들을 한 쌍씩 가져오면서 brown의 값과 비교해서 정답을 리턴한다.

제한 사항에 가로 길이가 더 길다고 나와있기 때문에 배열들을 가져올 때 height, width 순으로 가져온다.

```python
def divisior(num):
    factors = []
    for i in range(1, int(math.sqrt(num))+1):
        if num % i == 0:
            factors.append([i, num // i])
    return factors
```

