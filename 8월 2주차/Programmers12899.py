pattern = '124'

def solution(n):
    if n<=3:
        return pattern[n-1]
    else:
        q, r = divmod(n-1, 3)
        return solution(q) + pattern[r]

print('124'[2])