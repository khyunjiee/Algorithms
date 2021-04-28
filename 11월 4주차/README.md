# 11월 4주차 알고리즘 스터디

1. **이진 변환 반복하기 [70129](https://programmers.co.kr/learn/courses/30/lessons/70129)**

우선 문자열의 0의 개수를 세고, 문자열 길이에서 뺀 다음 `Integer.toBinaryString()` 을 사용해서 이진수로 바꿔주었다.

```java
while (s.length() > 1) {
    int zero = 0;
    changeTime++;

    for (String string : s.split("")) {
        if (string.equals("0")) {
            zero++;
        }
    }
    removeTime += zero;
    int num = s.length() - zero;
    s = Integer.toBinaryString(num);
}
```

---

2. **곱셈 [1629](https://www.acmicpc.net/problem/1629)**

(A * B) % C = ((A % C) * (B % C)) % C 라는 식을 적용했다.

```java
while (M > 0) {
    if (M % 2 == 1) {
        answer *= mul;
        answer %= O;
    }
    mul = ((mul%O)*(mul%O))%O;
    M /= 2;
}
```

----

3. **떡 먹는 호랑이 [2502](https://www.acmicpc.net/problem/2502)**

첫째날 떡의 개수를 A, 둘째날 떡의 개수를 B로 지칭한다.

배열에 A와 B로 초기화하고, day를 하나씩 빼가면서 전날과 전전날 떡의 개수를 더해주었다.

그 후에 할머니가 넘어온 D날의 떡의 개수를 추정하기 위해 list[1]의 A와 B의 개수를 세었다.

A에 1부터 대입해보며 할머니가 마지막 날 준 떡의 개수인 K가 딱 나누어 떨어질 때 break했다.

```java
while (day > 0) {
    String temp = list[1];
    list[1] = list[0] + list[1];
    list[0] = temp;
    day--;
}

for (String s : list[1].split("")) {
    if (s.equals("A")) aCount++;
    else if (s.equals("B")) bCount++;
}

while (true) {
    if ((numberOfRiceCake - (a * aCount)) % bCount == 0) {
        sb.append(a + "\n");
        b = (numberOfRiceCake - (a * aCount)) / bCount;
        sb.append(b);
        break;
    } else {
        a++;
    }
}
```

---

4. **퇴사 [14501](https://www.acmicpc.net/problem/14501)**

dynamic programming을 활용해서 풀었다.

dp[]는 당일까지의 수익금 배열이다.

(현재 날짜 + 상담 완료) 날짜의 수익금은 (현재 날짜 + 상담 완료)과 (오늘 이전까지 최대 수입 + 오늘 버는 수입) 중 최댓값을 저장한다.

그 후 max 값을 변경한다.

```java
for (int i = 1; i <=N+1; i++) {
    dp[i] = Math.max(dp[i], max);
    dp[days[i]+i] = Math.max(dp[days[i]+i],costs[i]+dp[i]);
    max = Math.max(max, dp[i]);
}
```

----

5. **모든 순열 [10974](https://www.acmicpc.net/problem/10974)**

dfs를 돌면서 모든 인덱스를 방문하여 output 배열에 넣는다.

이미 배열에 추가한 것은 visited 배열을 true로 만들어서 중복되지 않게 처리한다.

depth는 output에 들어간 숫자의 갯수이고, depth가 N이 되면 return한다.

```java
static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
    if (depth == r) {
        for (int i : output) {
            sb.append(i + " ");
        }
        sb.append("\n");
        return;
    }

    for (int i=0; i<n; i++) {
        if (visited[i] != true) {
            visited[i] = true;
            output[depth] = arr[i];
            perm(arr, output, visited, depth + 1, n, r);
            visited[i] = false;;
        }
    }
}
```

