# 8월 5주차 알고리즘

**1. <u>튜플</u> [64065](https://programmers.co.kr/learn/courses/30/lessons/64065)**

###### **문제 설명**

셀수있는 수량의 순서있는 열거 또는 어떤 순서를 따르는 요소들의 모음을 튜플(tuple)이라고 합니다. n개의 요소를 가진 튜플을 n-튜플(n-tuple)이라고 하며, 다음과 같이 표현할 수 있습니다.

- (a1, a2, a3, ..., an)

튜플은 다음과 같은 성질을 가지고 있습니다.

1. 중복된 원소가 있을 수 있습니다. ex : (2, 3, 1, 2)
2. 원소에 정해진 순서가 있으며, 원소의 순서가 다르면 서로 다른 튜플입니다. ex : (1, 2, 3) ≠ (1, 3, 2)
3. 튜플의 원소 개수는 유한합니다.

원소의 개수가 n개이고, **중복되는 원소가 없는** 튜플 `(a1, a2, a3, ..., an)`이 주어질 때(단, a1, a2, ..., an은 자연수), 이는 다음과 같이 집합 기호 '{', '}'를 이용해 표현할 수 있습니다.

- {{a1}, {a1, a2}, {a1, a2, a3}, {a1, a2, a3, a4}, ... {a1, a2, a3, a4, ..., an}}

예를 들어 튜플이 (2, 1, 3, 4)인 경우 이는

- {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}

와 같이 표현할 수 있습니다. 이때, 집합은 원소의 순서가 바뀌어도 상관없으므로

- {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
- {{2, 1, 3, 4}, {2}, {2, 1, 3}, {2, 1}}
- {{1, 2, 3}, {2, 1}, {1, 2, 4, 3}, {2}}

는 모두 같은 튜플 (2, 1, 3, 4)를 나타냅니다.

특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때, s가 표현하는 튜플을 배열에 담아 return 하도록 solution 함수를 완성해주세요.

######  **[제한사항]**

- s의 길이는 5 이상 1,000,000 이하입니다.
- s는 숫자와 '{', '}', ',' 로만 이루어져 있습니다.
- 숫자가 0으로 시작하는 경우는 없습니다.
- s는 항상 중복되는 원소가 없는 튜플을 올바르게 표현하고 있습니다.
- s가 표현하는 튜플의 원소는 1 이상 100,000 이하인 자연수입니다.
- return 하는 배열의 길이가 1 이상 500 이하인 경우만 입력으로 주어집니다.

###### **[입출력 예]**

| s                                 | result       |
| --------------------------------- | ------------ |
| `"{{2},{2,1},{2,1,3},{2,1,3,4}}"` | [2, 1, 3, 4] |
| `"{{1,2,3},{2,1},{1,2,4,3},{2}}"` | [2, 1, 3, 4] |
| `"{{20,111},{111}}"`              | [111, 20]    |
| `"{{123}}"`                       | [123]        |
| `"{{4,2,3},{3},{2,3,4,1},{2,3}}"` | [3, 2, 4, 1] |

###### [풀이법]

split 함수를 활용해서 풀었다.

```python
for s in strlist:
    ss = s.split(",")
    for i in ss:
        if int(i) not in answer:
            answer.append(int(i))
```

-----

**2. <u>위장</u> [42578](https://programmers.co.kr/learn/courses/30/lessons/42578)**

###### **문제 설명**

스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.

예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.

| 종류 | 이름                       |
| ---- | -------------------------- |
| 얼굴 | 동그란 안경, 검정 선글라스 |
| 상의 | 파란색 티셔츠              |
| 하의 | 청바지                     |
| 겉옷 | 긴 코트                    |

스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

###### **제한사항**

- clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
- 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
- 같은 이름을 가진 의상은 존재하지 않습니다.
- clothes의 모든 원소는 문자열로 이루어져 있습니다.
- 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
- 스파이는 하루에 최소 한 개의 의상은 입습니다.

###### **입출력 예**

| clothes                                                      | return |
| ------------------------------------------------------------ | ------ |
| [[yellow_hat, headgear], [blue_sunglasses, eyewear], [green_turban, headgear]] | 5      |
| [[crow_mask, face], [blue_sunglasses, face], [smoky_makeup, face]] | 3      |

###### **풀이법**

딕셔너리를 사용해서 풀었다.
필수로 하나씩 입어야하는 전제가 없기 때문에 값을 곱할 때 1을 더해주었다.

```python
for i, kind in clothes:
    if kind not in answer_dict:
        answer_dict[kind] = 1
    else:
        answer_dict[kind] += 1

for val in answer_dict.values():
    answer *= (val+1)
```

-----

**3. 여행경로 [43164](https://programmers.co.kr/learn/courses/30/lessons/43164)**

###### **문제 설명**

주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 ICN 공항에서 출발합니다.

항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

###### **제한사항**

- 모든 공항은 알파벳 대문자 3글자로 이루어집니다.
- 주어진 공항 수는 3개 이상 10,000개 이하입니다.
- tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
- 주어진 항공권은 모두 사용해야 합니다.
- 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
- 모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.

###### **입출력 예**

| tickets                                                     | return                         |
| ----------------------------------------------------------- | ------------------------------ |
| [[ICN, JFK], [HND, IAD], [JFK, HND]]                        | [ICN, JFK, HND, IAD]           |
| [[ICN, SFO], [ICN, ATL], [SFO, ATL], [ATL, ICN], [ATL,SFO]] | [ICN, ATL, ICN, SFO, ATL, SFO] |

###### **풀이법**

처음에 생각한대로 풀었더니 런타임 에러가 나서 구글링을 해봤다..
계속 재귀로 풀다가 런타임 에러가 났던 것이고, 스택으로 푸는 풀이법이 있어서 그것을 참고해서 풀었다.

###### 처음 풀이

```python
def recursion(tickets, start):
    end = ""
    for s, e in tickets:
        if s == start:
            if len(end) == 0:
                end = e
            elif end > e:
                end = e
    tickets.remove([start, end])
    return end

def solution(tickets):
    answer = ["ICN"]
    start = "ICN"

    while tickets:
        start = recursion(tickets, start)
        answer.append(start)

    return answer
```



###### 구글링한 풀이

```python
def solution(tickets):
    tickets.sort(reverse=True)
    routes = dict()
    for t1, t2 in tickets:
        if t1 in routes:
            routes[t1].append(t2)
        else:
            routes[t1] = [t2]
    stack = ['ICN']
    answer = []
    while stack:
        top = stack[-1]
        if top not in routes or len(routes[top])==0:
            answer.append(stack.pop())
        else:
            stack.append(routes[top].pop())
    answer.reverse()
    return answer
```

------

**4. 문자열 압축 [60057](https://programmers.co.kr/learn/courses/30/lessons/60057?language=java)**

###### **문제 설명**

데이터 처리 전문가가 되고 싶은 **어피치**는 문자열을 압축하는 방법에 대해 공부를 하고 있습니다. 최근에 대량의 데이터 처리를 위한 간단한 비손실 압축 방법에 대해 공부를 하고 있는데, 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 더 짧은 문자열로 줄여서 표현하는 알고리즘을 공부하고 있습니다.
간단한 예로 aabbaccc의 경우 2a2ba3c(문자가 반복되지 않아 한번만 나타난 경우 1은 생략함)와 같이 표현할 수 있는데, 이러한 방식은 반복되는 문자가 적은 경우 압축률이 낮다는 단점이 있습니다. 예를 들면, abcabcdede와 같은 문자열은 전혀 압축되지 않습니다. 어피치는 이러한 단점을 해결하기 위해 문자열을 1개 이상의 단위로 잘라서 압축하여 더 짧은 문자열로 표현할 수 있는지 방법을 찾아보려고 합니다.

예를 들어, ababcdcdababcdcd의 경우 문자를 1개 단위로 자르면 전혀 압축되지 않지만, 2개 단위로 잘라서 압축한다면 2ab2cd2ab2cd로 표현할 수 있습니다. 다른 방법으로 8개 단위로 잘라서 압축한다면 2ababcdcd로 표현할 수 있으며, 이때가 가장 짧게 압축하여 표현할 수 있는 방법입니다.

다른 예로, abcabcdede와 같은 경우, 문자를 2개 단위로 잘라서 압축하면 abcabc2de가 되지만, 3개 단위로 자른다면 2abcdede가 되어 3개 단위가 가장 짧은 압축 방법이 됩니다. 이때 3개 단위로 자르고 마지막에 남는 문자열은 그대로 붙여주면 됩니다.

압축할 문자열 s가 매개변수로 주어질 때, 위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.

###### **제한사항**

- s의 길이는 1 이상 1,000 이하입니다.
- s는 알파벳 소문자로만 이루어져 있습니다.

###### **입출력 예**

| s                            | result |
| ---------------------------- | ------ |
| `"aabbaccc"`                 | 7      |
| `"ababcdcdababcdcd"`         | 9      |
| `"abcabcdede"`               | 8      |
| `"abcabcabcabcdededededede"` | 14     |
| `"xababcdcdababcdcd"`        | 17     |

###### **풀이법**

언어를 파이썬에서 자바로 바꿨다..^^
시간복잡도를 신경 안써도 되는 문제여서 for문 안에서 전체적으로 탐색하는 방법으로 풀었다.

```java
for (int i = 1; i <= s.length() / 2; i++) {
    String now, next = "", result = "";
    int hit = 1;

    for (int j = 0; j <= s.length() / i; j++) {
        int start = j * i;
        int end = i * (j + 1) > s.length() ? s.length() : i * (j + 1);
        now = next;
        next = s.substring(start, end);

        if (now.equals(next)) {
            hit++;
        } else {
            result += (hitValue(hit) + now);
            hit = 1;
        }
    }

    result += (hitValue(hit) + next);
    answer = Math.min(answer, result.length());
}
```

