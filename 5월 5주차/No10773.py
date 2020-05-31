K = int(input())
arr = []

for _ in range(K):
    num = int(input())
    if num != 0:
        arr.append(num)
    elif num == 0 and len(arr) > 0:
        arr.pop()

if len(arr) == 0:
    print(0)
else:
    count = 0
    for i in arr:
        count += i
    print(count)