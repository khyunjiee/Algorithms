N = input()
nums = {0: 0, 1: 0, 2: 0, 3: 0, 4: 0, 5: 0, 6: 0, 7: 0, 8: 0}
name = []
share = 0
max = 0

for i in N:
    name.append(int(i))

for n in name:
    if n == 9:
        nums[6] += 1
    else:
        nums[n] += 1

nums[6] = int(nums[6] / 2 + nums[6] % 2)

for v in nums.values():
    if v > 0 and v > max:
        max = v

print(max+share)



