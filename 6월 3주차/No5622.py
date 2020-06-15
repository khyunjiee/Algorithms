str = list(input())
count = 0

for s in str:
    if ord(s) >= 87:
        count += 10
    elif ord(s) >= 84:
        count += 9
    elif ord(s) >= 80:
        count += 8
    elif ord(s) >= 77:
        count += 7
    elif ord(s) >= 74:
        count += 6
    elif ord(s) >= 71:
        count += 5
    elif ord(s) >= 68:
        count += 4
    else:
        count += 3

print(count)