list = []

for i in range(0, 20):
    list.append(i+1)

for i in range(0, 10):
    start, end = input().split()
    start = int(start)
    end = int(end)
    change = list[start-1: end]
    change.reverse()
    for j in range(0, len(change)):
        list[start-1+j] = change[j]
    if i == 9:
        for index in range(0, 20):
            print(list[index], end = ' ')
