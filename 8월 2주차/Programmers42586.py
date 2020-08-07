def solution(progresses, speeds):
    answer = list()
    day = 1

    while progresses:
        count = 0
        while progresses and progresses[0] + speeds[0] * day >= 100:
            count += 1
            progresses.pop(0)
            speeds.pop(0)

        if count != 0:
            answer.append(count)

        day += 1

    return answer