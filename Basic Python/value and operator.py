'''
변수 입력과 연산자


a = input("숫자를 입력하세요 : ")
print(a)

a, b = input("숫자를 입력하세요 : ").split()
print(a + b)    # a 와 b 는 string으로 input

a, b = input("숫자를 입력하세요 : ").split()
a = int(a)
b = int(b)
print(a + b)

# map이 정수화시켜서 매핑해
a, b = map(int, input("숫자를 입력하세요 : ").split())
print(a + b)
print(a - b)
print(a * b)
print(a / b)
print(a // b)   # 몫 연산자 //
print(a % b)    # 나머지 연산자 %
print(a ** b)   # 거듭제곱 **

'''

a = 4.3
b = 5
c = a + b
print(c)