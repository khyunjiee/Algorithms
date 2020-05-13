women = {}
men = {}
totalRoomNum = 0

totalNum, maxNum = input().split()
maxNum = int(maxNum)

for n in range(int(totalNum)):
    gen, grade = input().split()
    gen = int(gen)
    grade = grade + "학년"
    if gen == 1 and grade in men:
        men[grade] += 1
    elif gen == 1:
        men[grade] = 1
    elif gen == 0 and grade in women:
        women[grade] += 1
    else:
        women[grade] = 1

for w in women.values():
    if w < maxNum:
        totalRoomNum += 1
    elif w >= maxNum and w % maxNum > 0:
        totalRoomNum += int(w / maxNum) + 1
    else:
        totalRoomNum += int(w / maxNum)

for m in men.values():
    if m < maxNum:
        totalRoomNum += 1
    elif m >= maxNum and m % maxNum > 0:
        totalRoomNum += int(m / maxNum) + 1
    else:
        totalRoomNum += int(m / maxNum)

print(totalRoomNum)

