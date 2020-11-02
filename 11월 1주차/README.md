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

