def solution(number, k):
    number_list = list(number)
    stack = [number_list[0]]

    for i in range(1, len(number_list)):
        if k == 0:
            stack = stack + number_list[i:]
            break
        stack.append(number_list[i])
        if stack[-1] > stack[-2]:
            while len(stack) != 1 and stack[-1] > stack[-2] and k > 0:
                stack[-2], stack[-1] = stack[-1], stack[-2]
                stack.pop()
                k -= 1

    answer = "".join(stack[:len(number)-k])

    return answer