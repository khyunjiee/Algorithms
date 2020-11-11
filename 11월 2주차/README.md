# 11월 2주차 알고리즘 스터디

1. **스택 수열 [1874](https://www.acmicpc.net/problem/1874)**

count라는 변수를 1로 설정하고, stack에 push할 때마다 +1을 해주었다.

count가 입력받은 num보다 작으면 stack에 num까지 push한다.

그 후에 스택이 비었거나 맨 상위의 값이 num보다 작으면 수열을 완성시키지 못하는 것이므로 flag 변수를 true로 바꾼다.

수열을 완성시키지 못하는 경우가 아니면 num까지 stack을 pop한다.

```java
for (int i = 0; i < n; i++) {
    int num = Integer.parseInt(br.readLine());

    while (count <= num) {
        stack.push(count++);
        sb.append("+\n");
    }

    if (stack.isEmpty() || stack.peek() < num) flag = true;

    while (!stack.isEmpty() && stack.peek() >= num) {
        stack.pop();
        sb.append("-\n");
    }
}
```

-----

2. **프린터 큐 [1966](https://www.acmicpc.net/problem/1966)**

문서의 중요도와 인덱스 값을 class로 관리했다.

그리고 Queue가 아닌 ArrayList로 add, remove를 하며 순서 count를 셌다.

```java
for (int i = 0; i < testcase; i++) {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    ArrayList<Element> list = new ArrayList<>();

    st = new StringTokenizer(br.readLine());
    for (int j = 0; j < n; j++) {
        list.add(new Element(j, Integer.parseInt(st.nextToken())));
    }

    int count = 1;
    base:
    while (!list.isEmpty()) {
        Element element = list.get(0);
        for (int j = 1; j < list.size(); j++) {
            if (element.value < list.get(j).value) {
                list.remove(0);
                list.add(element);
                continue base;
            }
        }
        if (element.position == m) break;
        list.remove(0);
        count++;
    }
    sb.append(count + "\n");
}
```

