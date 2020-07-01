'''
반복문 (for, while)

a = range(1, 11)   # 순차적으로 정수 리스트를 만듦
print(list(a))

for i in range(1, 11):
    print(i)

for i in range(10, 0, -2):
    print(i)

i = 1
while i <= 10:
    print(i)
    i = i + 1

i = 10
while i >= 1:
    print(i)
    i = i - 1

i = 1
while True:     # 무한반복문
    print(i)
    if i == 10:
        break
    i += 1

for i in range(1, 11):
    if i % 2 == 0:
        continue
    print(i)
'''

for i in range(1, 11):
    print(i)
    if i > 15:
        break
else:   # for문이 정상적으로 다 돌았으면 else를 마지막으로 실행
    print(11)


