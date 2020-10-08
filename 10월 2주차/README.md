## 2020년 10월 2주차 알고리즘

1. **스킬트리 [49993](https://programmers.co.kr/learn/courses/30/lessons/49993)**

###### **문제 설명**

선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.

예를 들어 선행 스킬 순서가 `스파크 → 라이트닝 볼트 → 썬더`일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.

위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 따라서 `스파크 → 힐링 → 라이트닝 볼트 → 썬더`와 같은 스킬트리는 가능하지만, `썬더 → 스파크`나 `라이트닝 볼트 → 스파크 → 힐링 → 썬더`와 같은 스킬트리는 불가능합니다.

선행 스킬 순서 skill과 유저들이 만든 스킬트리[1](https://programmers.co.kr/learn/courses/30/lessons/49993#fn1)를 담은 배열 skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.

###### **제한 조건**

- 스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
- 스킬 순서와 스킬트리는 문자열로 표기합니다.
  - 예를 들어, `C → B → D` 라면 CBD로 표기합니다
- 선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
- skill_trees는 길이 1 이상 20 이하인 배열입니다.
- skill_trees의 원소는 스킬을 나타내는 문자열입니다.
  - skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.

###### **입출력 예**

| skill   | skill_trees                         | return |
| ------- | ----------------------------------- | ------ |
| `"CBD"` | `["BACDE", "CBADF", "AECB", "BDA"]` | 2      |

###### **입출력 예 설명**

- BACDE: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트립니다.
- CBADF: 가능한 스킬트리입니다.
- AECB: 가능한 스킬트리입니다.
- BDA: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.

###### **풀이법**

skill_tree를 순회하며 하나의 스킬이 skill에 포함되어있지 않을 경우 해당 스킬을 빈 문자열로 교체해주었다.

skill_tree를 모두 순회하면 남게되는 트리들은 선행 스킬이 포함되었을 경우에만 해당된다.

교체된 트리들을 한번 더 순회하면서 해당 트리에서 indexOf가 0일 경우에만 answer++을 해주었다.

선행 스킬의 첫번째는 무조건 트리에 포함되어있어야 하기 때문이다.

```java
for (int i = 0; i < skill_trees.length; i++) {
    int len = skill_trees[i].length();
    String skill_clones = new String(skill_trees[i]);
    for (int j = 0; j < len; j++) {
        String one = String.valueOf(skill_clones.charAt(j));
        if (!skill.contains(one)) skill_trees[i] = skill_trees[i].replace(one, "");
    }
}

for (String tree : skill_trees) {
    if (skill.indexOf(tree) == 0) answer++;
}
```

------

2. **단속카메라 [42884](https://programmers.co.kr/learn/courses/30/lessons/42884)**

###### **문제 설명**

고속도로를 이동하는 모든 차량이 고속도로를 이용하면서 단속용 카메라를 한 번은 만나도록 카메라를 설치하려고 합니다.

고속도로를 이동하는 차량의 경로 routes가 매개변수로 주어질 때, 모든 차량이 한 번은 단속용 카메라를 만나도록 하려면 최소 몇 대의 카메라를 설치해야 하는지를 return 하도록 solution 함수를 완성하세요.

###### **제한사항**

- 차량의 대수는 1대 이상 10,000대 이하입니다.
- routes에는 차량의 이동 경로가 포함되어 있으며 routes[i][0]에는 i번째 차량이 고속도로에 진입한 지점, routes[i][1]에는 i번째 차량이 고속도로에서 나간 지점이 적혀 있습니다.
- 차량의 진입/진출 지점에 카메라가 설치되어 있어도 카메라를 만난것으로 간주합니다.
- 차량의 진입 지점, 진출 지점은 -30,000 이상 30,000 이하입니다.

###### 입출력 예

| routes                                   | return |
| ---------------------------------------- | ------ |
| [[-20,15], [-14,-5], [-18,-13], [-5,-3]] | 2      |

###### **입출력 예 설명**

-5 지점에 카메라를 설치하면 두 번째, 네 번째 차량이 카메라를 만납니다.

-15 지점에 카메라를 설치하면 첫 번째, 세 번째 차량이 카메라를 만납니다.

###### **풀이법**

```java
for (int i = 1; i < routes.length; ++i) {
    int in = routes[i][0];
    int out = routes[i][1];

    if (in > max || out < min) {
        answer++;
        min = in;
        max = out;
    } else {
        min = in > min ? in : min;
        max = out < max ? out : max;
    }
}
```

-----

3. **순위 [49191](https://programmers.co.kr/learn/courses/30/lessons/49191)**

###### **문제 설명**

n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다. 권투 경기는 1대1 방식으로 진행이 되고, 만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다. 심판은 주어진 경기 결과를 가지고 선수들의 순위를 매기려 합니다. 하지만 몇몇 경기 결과를 분실하여 정확하게 순위를 매길 수 없습니다.

선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때 정확하게 순위를 매길 수 있는 선수의 수를 return 하도록 solution 함수를 작성해주세요.

###### **제한사항**

- 선수의 수는 1명 이상 100명 이하입니다.
- 경기 결과는 1개 이상 4,500개 이하입니다.
- results 배열 각 행 [A, B]는 A 선수가 B 선수를 이겼다는 의미입니다.
- 모든 경기 결과에는 모순이 없습니다.

###### **입출력 예**

| n    | results                                  | return |
| ---- | ---------------------------------------- | ------ |
| 5    | [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]] | 2      |

###### **입출력 예 설명**

2번 선수는 [1, 3, 4] 선수에게 패배했고 5번 선수에게 승리했기 때문에 4위입니다.
5번 선수는 4위인 2번 선수에게 패배했기 때문에 5위입니다.

###### **풀이법**

Boxer 클래스를 만들어 해당 복서가 이긴 사람들의 Set, 진 사람들의 Set을 관리했다.

자신이 진 플레이어면 해당 플레이어가 진 사람들도 모두 진 사람들이기 때문에 Set에 추가했다.

똑같이, 자신이 이긴 플레이어의 이긴 사람들은 모두 이길 수 있는 사람들이기 때문에 Set에 추가했다.

```java
for (int i = 0; i < n; i++) {
    for (int j = 1; j <= n; j++) {
        Boxer boxer = boxers[j];
        Set<Integer> winners = new HashSet<>();

        for (Integer win : boxer.win) {
            for (Integer winOfWin : boxers[win].win) {
                winners.add(winOfWin);
            }
        }
        boxer.win.addAll(winners);

        Set<Integer> losers = new HashSet<>();

        for (Integer lose : boxer.lose) {
            for (Integer loseOfLose : boxers[lose].lose) {
                losers.add(loseOfLose);
            }
        }
        boxer.lose.addAll(losers);
    }
}
```

------

4. **N으로 표현 [42895](https://programmers.co.kr/learn/courses/30/lessons/42895)**

###### **문제 설명**

아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.

12 = 5 + 5 + (5 / 5) + (5 / 5)
12 = 55 / 5 + 5 / 5
12 = (55 + 5) / 5

5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
이처럼 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.

###### **제한사항**

- N은 1 이상 9 이하입니다.
- number는 1 이상 32,000 이하입니다.
- 수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
- 최솟값이 8보다 크면 -1을 return 합니다.

###### **입출력 예**

| N    | number | return |
| ---- | ------ | ------ |
| 5    | 12     | 4      |
| 2    | 11     | 3      |

###### **입출력 예 설명**

* 예제 #1
  문제에 나온 예와 같습니다.

* 예제 #2
  `11 = 22 / 2`와 같이 2를 3번만 사용하여 표현할 수 있습니다.

###### **풀이법**

8이 넘어가면 -1로 반환하기 때문에, 1번부터 8번까지의 set을 만든다.

1번 set은 N, 2번 set은 NN과 N+N, N-N, N*N, N/N을 담는다. 여기서, N은 그 전의 1번 set의 요소.

3번 set은 NNN과 N+NN, N-NN ... NN/N을 담는다. 여기서, NN과 N은 1, 2번의 set 요소.

이렇게 쭉 8번까지 담는데, 그 전에 number가 발생하면 바로 return, 8번까지 담는데 number가 나오지 않으면 while문을 break로 탈출한다.

```java
while (answer < 8) {
    if (list.get(answer).contains(number)) break;
    answer++;

    HashSet<Integer> nset = new HashSet<>();
    String n = String.valueOf(N);
    for (int i = 0; i < answer; i++) n += String.valueOf(N);
    nset.add(Integer.parseInt(n));

    for (int i = 0; i < answer; i++) {
        for (int j = 0; i + j < answer; j++) {
            for (Iterator it1 = list.get(i).iterator(); it1.hasNext();) {
                int n1 = (int) it1.next();
                for (Iterator it2 = list.get(j).iterator(); it2.hasNext();) {
                    int n2 = (int) it2.next();
                    nset.add(n1 + n2);
                    nset.add(n1 - n2);
                    nset.add(n1 * n2);
                    if (n2 != 0) nset.add(n1 / n2);
                }
            }
        }
    }
    list.add(nset);
}
```

