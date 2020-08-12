import math

def divisior(num):
    factors = []
    for i in range(1, int(math.sqrt(num))+1):
        if num % i == 0:
            factors.append([i, num // i])
    return factors



def solution(brown, yellow):
    answer = []
    factors = divisior(yellow)

    for index, (height, width) in enumerate(factors):
        if (width + height + 2) * 2 == brown:
            answer.append(width + 2)
            answer.append(height + 2)

    return answer