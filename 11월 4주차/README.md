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

