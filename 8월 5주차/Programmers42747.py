def solution(citations):
    answer = 0
    citations.sort()
    maxNum = max(citations)
    bigger, smaller = 0, 0

    for i in range(maxNum+1):
        for j in citations:
            if j >= i:
                bigger += 1
            if j <= i:
                smaller += 1
            if bigger >= i and smaller <= i:
                answer = max(answer, i)
        bigger, smaller = 0, 0

    return answer