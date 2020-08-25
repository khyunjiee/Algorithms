def solution(prices):
    answer = []

    for corrent_index in range(len(prices)):
        for smaller_index in range(corrent_index, len(prices)):
            if prices[corrent_index] > prices[smaller_index]:
                answer.append(smaller_index - corrent_index)
                break
            elif smaller_index == len(prices)-1 and prices[corrent_index] <= prices[smaller_index]:
                answer.append(smaller_index - corrent_index)
                break

    return answer

print(solution([1, 2, 3, 2, 3]))