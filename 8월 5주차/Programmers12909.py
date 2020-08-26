def solution(s):
    answer = False
    count = 0

    # ( 개수 == ) 개수
    # 첫 (가 ) 앞에 있어야함
    # 마지막 )가 마지막 ( 앞에 있어야함

    for p in s:
        if count < 0:
            break
        if p == '(':
            count += 1
        elif p == ')':
            count -= 1

    if count == 0:
        answer = True

    return answer