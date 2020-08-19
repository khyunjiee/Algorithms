from collections import deque

def solution(numbers, target):
    answer = 0
    length = len(numbers)
    q = deque()
    q.append((numbers[0], 0))
    q.append((-numbers[0], 0))

    while q:
        lists = q.popleft()

        if lists[1] < length-1:
            if lists[0] + numbers[lists[1] + 1] == target and lists[1] + 1 == length-1:
                answer += 1
            else:
                q.append((lists[0] + numbers[lists[1] + 1], lists[1] + 1))
            if lists[0] - numbers[lists[1] + 1] == target and lists[1] + 1 == length-1:
                answer += 1
            else:
                q.append((lists[0] - numbers[lists[1] + 1], lists[1] + 1))

    return answer