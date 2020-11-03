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



