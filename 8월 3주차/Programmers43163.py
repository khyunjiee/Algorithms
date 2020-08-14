def solution(begin, target, words):
    answer = 0
    remain = list()

    if len(words) == 0:
        return 0

    if target not in words:
        return 0

    if begin == target:
        return answer

    for word in words:
        num = 0
        for index in range(len(begin)):
            if begin[index] != word[index]:
                num += 1
        if num == 1:
            remain.append(word)

    for remain_word in remain:
        words.remove(remain_word)

    for word in remain:
        answer = solution(word, target, words)
        break

    answer += 1

    return answer