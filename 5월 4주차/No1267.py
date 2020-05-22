callNum = int(input())
callList = list(map(int, input().split()))
yCount = 0
mCount = 0

# total : 총 시간, sec: 기준 시간, count: 기준 돈 , money: 현재 돈
def callBill(total, sec, count, money):
    if int(total / sec) > 0:
        money += count * int(total / sec)
        if int(total % sec) >= 0:
            money += count
    elif int(total / sec) == 0 and int(total % sec) > 0:
        money += count
    else:
        money = 0
    return money

for i in range(len(callList)):
    yCount = callBill(callList[i], 30, 10, yCount)
    mCount = callBill(callList[i], 60, 15, mCount)

if yCount > mCount:
    print("M " + str(mCount))
elif yCount < mCount:
    print("Y " + str(yCount))
else:
    print("Y M " + str(yCount))

