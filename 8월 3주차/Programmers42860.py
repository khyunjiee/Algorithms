# 아스키 코드 계산 함수
def calculation(character, standard):
    if ord(character) > ord(standard):
        return ord('Z') - ord(character) + 1
    else:
        return ord(character) - ord('A')

# 아스키 코드 계산 리스트 반환 함
def change(name, result):
    for c in name:
        result.append(calculation(c, 'N'))
    return result



def solution(name):
    answer = 0
    result = change(name, list())

    a_cnt = 0
    a_max = 0
    a_index = 0
    a_startIndex = 0

    left_right_cnt = 0

    for i, n in enumerate(result):
        if n == 0:
            a_cnt += 1
            if a_cnt > a_max:
                a_max = a_cnt
                a_index = i
        else:
            answer += n
            a_cnt = 0

    a_startIndex = a_index - a_max + 1

    if a_startIndex == 0 or a_startIndex == len(result)-1:
        answer += len(result) - 1 - a_max
    else:
        behind_a_left = len(result) - 1 - a_index
        if a_startIndex <= behind_a_left:
            left_right_cnt = (a_startIndex-1) * 2 + behind_a_left
        else:
            left_right_cnt = (a_startIndex-1) + behind_a_left * 2
        answer += min(left_right_cnt, len(result) - 1)

    return answer