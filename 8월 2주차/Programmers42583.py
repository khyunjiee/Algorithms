def solution(bridge_length, weight, truck_weights):
    answer = 0
    going = list()
    time = list()

    while going or truck_weights:
        answer += 1

        if time:
            if time[0] + bridge_length == answer:
                going.pop(0)
                time.pop(0)

        if truck_weights:
            if sum(going) + truck_weights[0] <= weight:
                going.append(truck_weights.pop(0))
                time.append(answer)

    return answer
