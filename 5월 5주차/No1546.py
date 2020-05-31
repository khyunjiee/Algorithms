count = int(input())
temp = input()
scores = temp.split(' ')
max = 0
total = 0

for i in range(len(scores)):
    scores[i] = int(scores[i])
    if scores[i] > max:
        max = scores[i]

for i in range(len(scores)):
    scores[i] = scores[i] / max * 100
    total += scores[i]

print('%0.6f'%(total/len(scores)))

