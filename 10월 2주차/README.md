## 2020년 10월 2주차 알고리즘

**1. 스킬트리 [49993](https://programmers.co.kr/learn/courses/30/lessons/49993)**

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

