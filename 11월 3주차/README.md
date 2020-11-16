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

