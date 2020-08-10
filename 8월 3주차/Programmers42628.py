def solution(operations):
    answer = []
    queue = list()

    for op in operations:
        if op[0] == "I":
            queue.append(int(op[2:]))
        elif len(queue) != 0 and op == "D 1":
            queue.remove(max(queue))
        elif len(queue) != 0 and op == "D -1":
            queue.remove(min(queue))

    if len(queue) == 0:
        answer.append(0)
        answer.append(0)
    else:
        answer.append(max(queue))
        answer.append(min(queue))

    return answer

print(solution(["I 7","I 5","I -5","D -1"]))