# 8월 셋째주 알고리즘

**1. 프로그래머스 문제** [**42579**](https://programmers.co.kr/learn/courses/30/lessons/42579)

###### **문제 설명**

스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

##### **제한사항**

- genres[i]는 고유번호가 i인 노래의 장르입니다.
- plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
- genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
- 장르 종류는 100개 미만입니다.
- 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
- 모든 장르는 재생된 횟수가 다릅니다.

##### **입출력 예**

| genres                                | plays                      | return       |
| ------------------------------------- | -------------------------- | ------------ |
| [classic, pop, classic, classic, pop] | [500, 600, 150, 800, 2500] | [4, 1, 3, 0] |

##### **입출력 예 설명**

classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.

- 고유 번호 3: 800회 재생
- 고유 번호 0: 500회 재생
- 고유 번호 2: 150회 재생

pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.

- 고유 번호 4: 2,500회 재생
- 고유 번호 1: 600회 재생

따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.

**풀이법**

노래 장르별로 딕셔너리를 생성하고, 고유값과 재생 횟수를 저장했다.
그리고 장르별 총 재생 횟수를 저장하는 딕셔너리도 생성했다.

그 후에 총 재생 횟수를 정렬한 후 노래 장르별로 저장한 딕셔너리에서 고유값을 찾았다.

```python
sortTotalPlays = sorted(totalPlays.items(), key=lambda x: x[1], reverse=True)

for key in sortTotalPlays:
    playList = genreDict[key[0]]
    playList = sorted(playList, key=lambda x: (-x[0], x[1]))

for i in range(len(playList)):
    if i == 2:
        break
    answer.append(playList[i][1])
```

------

**2. 프로그래머스 문제 [43165](https://programmers.co.kr/learn/courses/30/lessons/43165)**

###### **문제 설명**

n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

```
-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
```

사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

##### **제한사항**

- 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
- 각 숫자는 1 이상 50 이하인 자연수입니다.
- 타겟 넘버는 1 이상 1000 이하인 자연수입니다.

##### **입출력 예**

| numbers         | target | return |
| --------------- | ------ | ------ |
| [1, 1, 1, 1, 1] | 3      | 5      |

**풀이법**

python 내장 자료구조인 deque를 사용했다.

```python
while q:
    lists = q.poplef
    if lists[1] < length-1:
        if lists[0] + numbers[lists[1] + 1] == target and lists[1] + 1 == length-1:
            answer += 1
        else:
            q.append((lists[0] + numbers[lists[1] + 1], lists[1] + 1))
        if lists[0] - numbers[lists[1] + 1] == target and lists[1] + 1 == length-1:
            answer += 1
        else:
            q.append((lists[0] - numbers[lists[1] + 1], lists[1] + 1))
```

------

**3. 프로그래머스 문제 [42883](https://programmers.co.kr/learn/courses/30/lessons/42883)**

###### **문제 설명**

어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

##### **제한 조건**

- number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
- k는 1 이상 `number의 자릿수` 미만인 자연수입니다.

##### **입출력 예**

| number     | k    | return |
| ---------- | ---- | ------ |
| 1924       | 2    | 94     |
| 1231234    | 3    | 3234   |
| 4177252841 | 4    | 775841 |

**풀이법**

스택 개념을 활용해서 풀었다.
첫 번째 숫자부터 하나씩 넣고 마지막에 넣은 것과 그 전에 넣은 것을 비교하여
마지막에 넣은 숫자가 더 클 때 스택을 조정해준다.

```python
for i in range(1, len(number_list)):
    if k == 0:
        stack = stack + number_list[i:]
        break
    stack.append(number_list[i])
    if stack[-1] > stack[-2]:
        while len(stack) != 1 and stack[-1] > stack[-2] and k > 0:
            stack[-2], stack[-1] = stack[-1], stack[-2]
            stack.pop()
            k -= 1
```

