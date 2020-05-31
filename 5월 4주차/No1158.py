# num_of_people, criteria = input().split()
# num_of_people = int(num_of_people)
# criteria = int(criteria)-1
# people = {}
# num = criteria
# sequence = 1
# count = 0
# boolValue = True
#
# for index in range(num_of_people):
#     people[index+1] = 0
#
# print("<", end='')
# while boolValue:
#     for index in range(1, num_of_people+1):
#         if people[index] == 0 and num != 0:
#             num -= 1
#         elif people[index] == 0 and num == 0:
#             people[index] = sequence
#             num = criteria
#             sequence = sequence + 1
#             count = count + 1
#             print(index, end='')
#             if count != num_of_people:a
#                 print(" ", end='')
#     if count == num_of_people:
#         print(">", end='')
#         boolValue = False
#

N, K = map(int, input().split())
people = list(range(1, N+1))
result = []
maximum = K - 1

while True:
    result.append(people.pop(maximum))
    maximum = (maximum+maximum-1) % len(people)

print('<' + people + '>')