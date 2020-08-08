def solution(priorities, location):
    answer = 0
    waiting = list()

    for i in range(len(priorities)):
        waiting.append(i)

    while priorities:
        num = max(priorities)
        answer += 1

        while True:
            if priorities[0] < num:
                priorities.append(priorities.pop(0))
                waiting.append(waiting.pop(0))
            else:
                priorities.pop(0)
                break

        if waiting.pop(0) == location:
            break

    return answer