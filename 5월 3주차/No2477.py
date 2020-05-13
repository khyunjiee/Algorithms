K = int(input())

direction = []
length = []

xMax = 0
yMax = 0
xMin = 0
yMin = 0

for _ in range(6):
    str = input().split()

    if (int(str[0]) == 1 or int(str[0]) == 2) and xMax < int(str[1]):
        xMax = int(str[1])
    elif (int(str[0]) == 3 or int(str[0]) == 4) and yMax < int(str[1]):
        yMax = int(str[1])

    direction.append(int(str[0]))
    length.append(int(str[1]))

for n in range(6):
    if (direction[n-1] == 1 and direction[n] == 3) or (direction[n-1] == 4 and direction[n] == 1) or (direction[n-1] == 2 and direction[n] == 4) or (direction[n-1] == 3 and direction[n] == 2):
        xMin = length[n-1]
        yMin = length[n]

print(((xMax * yMax) - (xMin * yMin)) * K)
