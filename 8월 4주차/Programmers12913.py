def solution(land):
    answer = 0

    for row in range(1, len(land)):
        for index in range(4):
            rest_index = set(range(4)) - {index}
            land[row][index] += max([land[row-1][i] for i in rest_index])
    answer = max(land[-1])

    return answer