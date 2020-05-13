N = int(input())
nums = []

for x in input().split():
    nums.append(int(x))

v = int(input())
print(nums.count(v))