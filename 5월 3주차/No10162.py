T = int(input())
result = ""

if T >= 300:
    result += str(int(T / 300)) + " "
    T -= int(T / 300) * 300
else:
    result += "0 "

if T >= 60:
    result += str(int(T / 60)) + " "
    T -= int(T / 60) * 60
else:
    result += "0 "

if T >= 10:
    result += str(int(T / 10))
    T -= int(T / 10) * 10
else:
    result += "0"

if T == 0:
    print(result)
else:
    print(-1)