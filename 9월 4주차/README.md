## 2020년 9월 4주차 알고리즘

**1. 가장 큰 수 [42746](https://programmers.co.kr/learn/courses/30/lessons/42746)**

###### **문제 설명**

0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

###### **제한 사항**

- numbers의 길이는 1 이상 100,000 이하입니다.
- numbers의 원소는 0 이상 1,000 이하입니다.
- 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

###### **입출력 예**

| numbers           | return    |
| ----------------- | --------- |
| [6, 10, 2]        | "6210"    |
| [3, 30, 34, 5, 9] | "9534330" |

###### **풀이법**

numbers를 String으로 변환하여 큰 수부터 answer에 더해줬다.

```java
for (int i = 0; i < numbers.length; i++) {
    arr[i] = (String.valueOf(numbers[i]));
}
Arrays.sort(arr, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return (o2 + o1).compareTo(o1 + o2);
    }
});
```

---

**2. 정수 삼각형 [43105](https://programmers.co.kr/learn/courses/30/lessons/43105)**

###### **문제 설명**

![스크린샷 2018-09-14 오후 5.44.19.png](https://grepp-programmers.s3.amazonaws.com/files/production/97ec02cc39/296a0863-a418-431d-9e8c-e57f7a9722ac.png)

위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다. 아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.

삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.

###### **제한사항**

- 삼각형의 높이는 1 이상 500 이하입니다.
- 삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.

###### **입출력 예**

| triangle                                                | result |
| ------------------------------------------------------- | ------ |
| [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]] | 30     |

###### **풀이법**

맨 아래쪽 트리 부분부터 최댓값으로 더해나갔다.

예를 들어서, 위의 그림에서 4번째 행의 원소들과 그 원소들에서 갈 수 있는 5번째 행의 두 개의 원소들 중에서 큰 값을 4번째 행의 원소와 더했다.

그 값을 4번째 행에 다 적용하고, 0번째 행까지 저장해나갔다.

![IMG_A37A3E0683CE-1](https://user-images.githubusercontent.com/49138331/93873494-bff28b80-fd0c-11ea-96e0-92e70590553f.jpeg)

-------

**3. 가장 먼 노드 [49189](https://programmers.co.kr/learn/courses/30/lessons/49189)**

###### **문제 설명**

n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다. 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다. 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.

노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때, 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.

###### **제한사항**

- 노드의 개수 n은 2 이상 20,000 이하입니다.
- 간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
- vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.

###### **입출력 예**

| n    | vertex                                                   | return |
| ---- | -------------------------------------------------------- | ------ |
| 6    | [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]] | 3      |

###### **입출력 예 설명**

예제의 그래프를 표현하면 아래 그림과 같고, 1번 노드에서 가장 멀리 떨어진 노드는 4,5,6번 노드입니다.

![image.png](https://grepp-programmers.s3.amazonaws.com/files/ybm/fadbae38bb/dec85ab5-0273-47b3-ba73-fc0b5f6be28a.png)

###### **풀이법**

bfs를 사용해서 풀었다.

distance 배열에 간선의 수를 저장하여 max 값이면 answer을 1씩 더해주었다.

```java
while (!queue.isEmpty()) {
    int here = queue.poll();
    for (int i = 0; i < edge.length; i++) {
        int there = -1;
        if (edge[i][0] == here) {
            there = edge[i][1];
        } else if (edge[i][1] == here) {
            there = edge[i][0];
        }

        if (there != -1 && distance[there] == 0) {
            queue.offer(there);
            distance[there] = distance[here] + 1;
            parent[there] = here;
        }
    }
}
```

