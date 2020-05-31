N = int(input())
total = []

for _ in range(N):
    temp = input().split(' ')
    temp[0] = int(temp[0])
    temp[1] = int(temp[1])
    total.append(temp)

total.sort()

for i in range(N):
    print(total[i][0], total[i][1])

