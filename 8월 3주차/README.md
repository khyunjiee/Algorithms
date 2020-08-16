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

**2. 프로그래머스 문제 [42842](https://github.com/khyunjiee/Algorithms/blob/master/8%EC%9B%94%203%EC%A3%BC%EC%B0%A8/Programmers42842.py)**

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

--------

**3. 프로그래머스 문제 [43163](https://github.com/khyunjiee/Algorithms/blob/master/8%EC%9B%94%203%EC%A3%BC%EC%B0%A8/Programmers43163.py)**

###### **문제 설명**

두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.

```
1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
2. words에 있는 단어로만 변환할 수 있습니다.
```

예를 들어 begin이 hit, target가 cog, words가 [hot,dot,dog,lot,log,cog]라면 hit -> hot -> dot -> dog -> cog와 같이 4단계를 거쳐 변환할 수 있습니다.

두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.

##### **제한사항**

- 각 단어는 알파벳 소문자로만 이루어져 있습니다.
- 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
- words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
- begin과 target은 같지 않습니다.
- 변환할 수 없는 경우에는 0를 return 합니다.

##### **입출력 예**

| begin | target | words                          | return |
| ----- | ------ | ------------------------------ | ------ |
| hit   | cog    | [hot, dot, dog, lot, log, cog] | 4      |
| hit   | cog    | [hot, dot, dog, lot, log]      | 0      |

**풀이법**

재귀함수를 활용해서 풀었다.

begin 단어랑 한 글자만 다른 단어들을 words 배열에서 찾아서 remain 배열에 추가했다.

그 후에 remain 함수에 append한 단어들을 words에서 remove한다.

그러고 begin과 target 단어가 같을 경우에 return 했다.

```python
    for word in words:
        num = 0
        for index in range(len(begin)):
            if begin[index] != word[index]:
                num += 1
        if num == 1:
            remain.append(word)

    for remain_word in remain:
        words.remove(remain_word)

    for word in remain:
        answer = solution(word, target, words)
        break

    answer += 1
```

------

**4. 프로그래머스 문제 [42892](https://programmers.co.kr/learn/courses/30/lessons/42892)**

###### **문제 설명**

## 길 찾기 게임

전무로 승진한 라이언은 기분이 너무 좋아 프렌즈를 이끌고 특별 휴가를 가기로 했다.
내친김에 여행 계획까지 구상하던 라이언은 재미있는 게임을 생각해냈고 역시 전무로 승진할만한 인재라고 스스로에게 감탄했다.

라이언이 구상한(그리고 아마도 라이언만 즐거울만한) 게임은, 카카오 프렌즈를 두 팀으로 나누고, 각 팀이 같은 곳을 다른 순서로 방문하도록 해서 먼저 순회를 마친 팀이 승리하는 것이다.

그냥 지도를 주고 게임을 시작하면 재미가 덜해지므로, 라이언은 방문할 곳의 2차원 좌표 값을 구하고 각 장소를 이진트리의 노드가 되도록 구성한 후, 순회 방법을 힌트로 주어 각 팀이 스스로 경로를 찾도록 할 계획이다.

라이언은 아래와 같은 특별한 규칙으로 트리 노드들을 구성한다.

- 트리를 구성하는 모든 노드의 x, y 좌표 값은 정수이다.
- 모든 노드는 서로 다른 x값을 가진다.
- 같은 레벨(level)에 있는 노드는 같은 y 좌표를 가진다.
- 자식 노드의 y 값은 항상 부모 노드보다 작다.
- 임의의 노드 V의 왼쪽 서브 트리(left subtree)에 있는 모든 노드의 x값은 V의 x값보다 작다.
- 임의의 노드 V의 오른쪽 서브 트리(right subtree)에 있는 모든 노드의 x값은 V의 x값보다 크다.

아래 예시를 확인해보자.

라이언의 규칙에 맞게 이진트리의 노드만 좌표 평면에 그리면 다음과 같다. (이진트리의 각 노드에는 1부터 N까지 순서대로 번호가 붙어있다.)

![tree_3.png](https://grepp-programmers.s3.amazonaws.com/files/production/dbb58728bd/a5371669-54d4-42a1-9e5e-7466f2d7b683.jpg)

이제, 노드를 잇는 간선(edge)을 모두 그리면 아래와 같은 모양이 된다.

![tree_4.png](https://grepp-programmers.s3.amazonaws.com/files/production/6bd8f6496a/50e1df20-5cb7-4846-86d6-2a2f1e70c5da.jpg)

위 이진트리에서 전위 순회(preorder), 후위 순회(postorder)를 한 결과는 다음과 같고, 이것은 각 팀이 방문해야 할 순서를 의미한다.

- 전위 순회 : 7, 4, 6, 9, 1, 8, 5, 2, 3
- 후위 순회 : 9, 6, 5, 8, 1, 4, 3, 2, 7

다행히 두 팀 모두 머리를 모아 분석한 끝에 라이언의 의도를 간신히 알아차렸다.

그러나 여전히 문제는 남아있다. 노드의 수가 예시처럼 적다면 쉽게 해결할 수 있겠지만, 예상대로 라이언은 그렇게 할 생각이 전혀 없었다.

이제 당신이 나설 때가 되었다.

곤경에 빠진 카카오 프렌즈를 위해 이진트리를 구성하는 노드들의 좌표가 담긴 배열 nodeinfo가 매개변수로 주어질 때,
노드들로 구성된 이진트리를 전위 순회, 후위 순회한 결과를 2차원 배열에 순서대로 담아 return 하도록 solution 함수를 완성하자.

##### **제한사항**

- nodeinfo는 이진트리를 구성하는 각 노드의 좌표가 1번 노드부터 순서대로 들어있는 2차원 배열이다.
  - nodeinfo의 길이는 `1` 이상 `10,000` 이하이다.
  - nodeinfo[i] 는 i + 1번 노드의 좌표이며, [x축 좌표, y축 좌표] 순으로 들어있다.
  - 모든 노드의 좌표 값은 `0` 이상 `100,000` 이하인 정수이다.
  - 트리의 깊이가 `1,000` 이하인 경우만 입력으로 주어진다.
  - 모든 노드의 좌표는 문제에 주어진 규칙을 따르며, 잘못된 노드 위치가 주어지는 경우는 없다.

##### **입출력 예**

| nodeinfo                                                  | result                                    |
| --------------------------------------------------------- | ----------------------------------------- |
| [[5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]] | [[7,4,6,9,1,8,5,2,3],[9,6,5,8,1,4,3,2,7]] |

**풀이법**

못풀어서 구글링했어요..공부중..

------

**5. 프로그래머스 문제 [42860](https://programmers.co.kr/learn/courses/30/lessons/42860?language=python3)**

###### **문제 설명**

조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

조이스틱을 각 방향으로 움직이면 아래와 같습니다.

```
▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동
```

예를 들어 아래의 방법으로 JAZ를 만들 수 있습니다.

```
- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
```

만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

##### **제한 사항**

- name은 알파벳 대문자로만 이루어져 있습니다.
- name의 길이는 1 이상 20 이하입니다.

##### **입출력 예**

| name   | return |
| ------ | ------ |
| JEROEN | 56     |
| JAN    | 23     |

**풀이법**

우선…. 쉬운듯 복잡한 문제였다 ㅠ^ㅠ

A가 많을 때 왔다갔다 하는 부분이 관건이었던 것 같다.

A 뒤의 남아있는 문자의 개수가 앞의 개수보다 많다면 앞을 먼저 완성하고 다시 뒤로 가야하고,
만약 A 뒤의 남아있는 문자의 개수가 앞의 개수보다 많지 않다면 뒤를 먼저 완성해야한다.

```python
if a_startIndex == 0 or a_startIndex == len(result)-1:
    answer += len(result) - 1 - a_max
else:
    behind_a_left = len(result) - 1 - a_index
    if a_startIndex <= behind_a_left:
        left_right_cnt = (a_startIndex-1) * 2 + behind_a_left
    else:
        left_right_cnt = (a_startIndex-1) + behind_a_left * 2
    answer += min(left_right_cnt, len(result) - 1)
```

