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

----

3. **효율적인 해킹 [1325](https://www.acmicpc.net/problem/1325)**

계속 Java로 풀려고 노력하다가 답지를 복붙해도 시간초과가 나서 Python으로 풀었다..!

bfs에 더 맞는 문제같아서 bfs로 풀었다.

```python
def bfs(start):
    q = deque()
    q.append(start)
    visit = [0 for _ in range(n + 1)]
    visit[start] = 1
    cnt = 1
    while q:
        st = q.popleft()
        for i in s[st]:
            if visit[i] == 0:
                visit[i] = 1
                cnt += 1
                q.append(i)
    return cnt
```

---

4. **다음 순열 [10972](https://www.acmicpc.net/problem/10972)**

영역을 나누어서 숫자 순서를 바꿔주었다.

```java
public static boolean nextPermutation(int[] arr) {
    //뒤에서부터 탐색하면서 a-1보다 a가 더 큰 경우 찾음
    int a = arr.length - 1;
    while(a > 0 && arr[a-1] >= arr[a]) a--;
    if (a <= 0 ) return false;
        
    //다시 뒤에서부터 탐색하며 a-1보다 b가 더 큰 경우 찾음
    int b = arr.length - 1;
    while(arr[a-1] >= arr[b]) b--;
        
    //a랑 b를 swap
    int tmp = arr[a-1];
    arr[a-1] = arr[b];
    arr[b] = tmp;
        
    //a에서부터 끝까지를 오름차순 정렬 
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

-----

5. **단어 수학 [1339](https://www.acmicpc.net/problem/1339)**

문자 - 숫자 매핑으로 모든 경우 중 최댓값을 구하면 된다.

한 자리씩 추가하는 경우 문자 위치를 바꾸기 보다 *10을 활용하여 String을 사용할 때 오버헤드를 줄인다.

```java
private static void permutation(int depth) {
	if(depth == alphabet.size()) {
		int temp = calc();
		max = temp > max ? temp : max;
		return;
	}
		
	for(int i = 0 ; i < 10 ; ++i) {
		if(!selected[i]) {
			selected[i] = true;
			// 해쉬맵으로 문자 - 숫자를 매핑한다.
			map.put(alphabet.get(depth), i);
			permutation(depth + 1);
			selected[i] = false;
		}
	}
}

// 매핑된 문자 - 숫자를 바탕으로 합계 산출하기 
private static int calc() {
	int result = 0;
		
	for(int i = 0 ; i < N ; ++i) {
		int temp = 0;
		// String을 직접 핸들링하는 것은 부담이 크다(연산, 파싱) 
		for(char c : input[i]) {
			temp *= 10;
			temp += map.get(c);
		}
		result += temp;
	}
		
	return result;
}
```

