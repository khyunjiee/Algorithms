# 11월 1주차 알고리즘 스터디

1. **숨바꼭질 [1697](https://www.acmicpc.net/problem/1697)**

최단거리 찾는 문제로 여겨서 bfs로 풀었다.

```java
static void bfs(int num) {
    Queue<Integer> q = new LinkedList<>();
    q.add(num);
    check[num] = 1;

    while (!q.isEmpty()) {
        int temp = q.poll();

        for (int i = 0; i < 3; i++) {
            int next;

            if (i == 0) {
                next = temp + 1;
            } else if (i == 1) {
                next = temp - 1;
            } else {
                next = temp * 2;
            }

            if (next == K) {
                System.out.println(check[temp]);
                return;
            }

            if (next >= 0 && next < check.length && check[next] == 0) {
                q.add(next);
                check[next] = check[temp] + 1;
            }
        }
    }
}
```

-----

2. **단어 뒤집기 2 [17413](https://www.acmicpc.net/problem/17413)**

스택을 활용해서 풀었다.

값으로 <가 들어오면 >까지 answer에 그대로 더해주었고, <>사이에 있지 않으면 stack에 push했다.

반복문을 돌다가 공백이 나오면 쌓여있던 stack을 모두 pop해서 answer에 추가해주었다.

```java
while (true) {
    if (index == list.length) break;
    else if (list[index].equals("<")) {
        while (!stack.isEmpty()) answer += stack.pop();
        answer += list[index];
        flag = true;
    }
    else if (list[index].equals(">")) {
        answer += list[index];
        flag = false;
    }
    else if (flag) {
        answer += list[index];
    }
    else if (list[index].equals(" ")) {
        while (!stack.isEmpty()) answer += stack.pop();
        answer += " ";
    }
    else stack.push(list[index]);
    index++;
}
```

-----

3. **RGB 거리 [1149](https://www.acmicpc.net/problem/1149)** 

최솟값들을 찾아 더해서 배열에 저장했다.

마지막에는 N-1 행의 값들 중 작은 값을 구하면 답을 도출해낼 수 있다.

```java
houseColor[0][0] = houseCosts[0][0];
houseColor[0][1] = houseCosts[0][1];
houseColor[0][2] = houseCosts[0][2];

for (int i = 1; i < houses; i++) {
    houseColor[i][0] = Math.min(houseColor[i - 1][1], houseColor[i - 1][2]) + houseCosts[i][0];
    houseColor[i][1] = Math.min(houseColor[i - 1][0], houseColor[i - 1][2]) + houseCosts[i][1];
    houseColor[i][2] = Math.min(houseColor[i - 1][0], houseColor[i - 1][1]) + houseCosts[i][2];

        }
```

-----

4. **집합 [11723](https://www.acmicpc.net/problem/11723)**

우선 계속 시간 초과가 나서 당황했다. 근데 check를 할 때마다 println을 사용하는 것이 아니라 StringBuilder를 활용해서 한번에 모았다가 출력해주니까 시간 초과 문제는 해결됐다.

처음에는 HashSet을 활용해서 풀어주었는데 잘 풀리지 않아서 좀 찾아보니까 비트 마스크 문제라는 것을 알았다.

^ ~ << >> & | 등의 비트 연산자를 활용해서 풀었다.

또한 all, empty는 연산 string만 받고 number는 입력받지 않기 때문에 이 경우도 생각해주어야 한다.

```java
for (int i = 0; i < m; i++) {
    String operation = scanner.next();
    int num = 0;

    if (operation.equals("all")) {
        s = (1 << 21) -1;
    } else if (operation.equals("empty")) {
        s = 0;
    } else {
        num = scanner.nextInt();
    }

    if (operation.equals("add")) {
        s = s | (1 << num);
    } else if (operation.equals("remove")) {
        s = s &~ (1 << num);
    } else if (operation.equals("check")) {
        if ((s & (1 << num)) > 0) result.append("1\n");
        else result.append("0\n");
    } else if (operation.equals("toggle")) {
        s = s ^ (1 << num);
    }
}
```

