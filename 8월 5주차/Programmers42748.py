def solution(array, commands):
    answer = []

    for c in commands:
        list = array[c[0]-1:c[1]]
        list.sort()
        answer.append(list[c[2]-1])

    return answer