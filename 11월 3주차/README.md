# 11월 3주차 알고리즘 스터디

1. **이전 순열 [10973](https://www.acmicpc.net/problem/10973)**

저번 주에 풀었던 다음 순열에서 부등호만 바꿔주면 되는 문제였다.

배열의 뒤부터 탐색하여 앞보다 뒤의 값이 큰 인덱스를 찾아주고, 다시 뒤부터 탐색하여 해당 인덱스 값보다 첫 번째로 큰 값의 인덱스를 찾는다.

그 후에 두 인덱스 값을 swap한 후, 뒤쪽 배열을 내림차순으로 바꿔준다.

```java
private static boolean beforePermutation(int[] arr) {

    int a = arr.length - 1;
    while(a > 0 && arr[a-1] <= arr[a]) a--;
    if (a <= 0 ) return false;

    int b = arr.length - 1;
    while(arr[a-1] <= arr[b]) b--;

    int tmp = arr[a-1];
    arr[a-1] = arr[b];
    arr[b] = tmp;

    int start = a;
    int end = arr.length - 1;
    while(start < end) {
        tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
        start++;
        end--;
    }
    return true;
}
```

----

2. **설탕 배달 [2839](https://www.acmicpc.net/problem/2839)**

5와 3의 공배수일 경우 N에서 5를 먼저 빼고, 5나 3의 배수일 경우에는 N에서 해당 값을 빼준다.

모두 해당되지 않을 경우에는 N에서 5를 빼준다.

그 후에 count를 1 추가한다.

while문을 돌면서 N이 0 이하일 경우에는 -1을  출력하고, 0일 경우에는 count를 출력한다.

```java
while (true) {
    if (N % 5 == 0 && N % 3 == 0) {
        N -= 5;
    } else if (N % 5 == 0) {
        N -= 5;
    } else if (N % 3 == 0) {
        N -= 3;
    } else {
        N -= 5;
    }
    count++;

    if (N == 0) {
        System.out.println(count);
        break;
    }
    if (N < 0) {
        System.out.println(-1);
        break;
    }
}
```

----

3. **결혼식 [5567](https://www.acmicpc.net/problem/5567)**

처음에는 HashMap과 HashSet을 사용해서 풀었는데 런타임 에러가 났다.

그래서 배열로 바꿨다.

친구들 간의 관계를 담는 2차원 배열 friends와 초대 여부를 담는 invites 배열을 사용했다.

우선 관계가 있는 친구들끼리는 배열 값을 1로 초기화했다.

그 후에 1번인 상근이와 관련이 있으면, 그 친구를 초대하고 그 친구의 친구까지 초대해서 초대하는 명수를 리턴했다.

```java
for (int i = 2; i < N + 1; i++) {
    if (friends[1][i] == 1) {
        if (!invites[i]) {
            answer++;
            invites[i] = true;
        }
        for (int j = 2; j < N + 1; j++) {
            if (friends[i][j] == 1 && !invites[j]) {
                answer++;
                invites[j] = true;
            }
        }
    }
}
```

---

4. **구간 합 구하기 [11659](https://www.acmicpc.net/problem/11659)**

숫자 개수를 받은 후 배열에 처음부터 해당 구간까지의 합을 저장한다.

그 후의 구간의 start와 end값을 받아 해당 인덱스 값을 빼준다.

```java
for (int i = 0; i < M; i++) {
    st = new StringTokenizer(br.readLine());
    int start = Integer.parseInt(st.nextToken()) - 1;
    int end = Integer.parseInt(st.nextToken());

    int sum = numList[end] - numList[start];
    sb.append(sum + "\n");
}
```

----

5. **가장 큰 정사각형 찾기 https://programmers.co.kr/learn/courses/30/lessons/12905**

DP로 풀었다.

한 지점을 기준으로 우측, 아래쪽으로 탐색하면서 가장 큰 정사각형을 찾았다.

```java
for(int i = 1 ; i < arr.length; i++) {
    for(int j = 1 ; j < arr[0].length ; j++) {
        if(arr[i][j]==1) {
            int min = Math.min(arr[i-1][j], arr[i][j-1]);
            min = Math.min(min, arr[i-1][j-1]);

            arr[i][j] = min + 1;
            answer = Math.max(answer, arr[i][j]);
        }
    }
}
```