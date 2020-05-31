N = int(input())
N = bin(N)
result = N[:1:-1]
print(int('0b'+result, 2))