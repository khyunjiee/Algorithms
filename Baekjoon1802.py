# 재귀함수 선언
def paper_fold(case):
    fold_list = list(case)
    # center_element = fold_list[int(len(fold_list)/2)+1]
    left_list = fold_list[0: int(len(fold_list)/2)+1]
    right_list = fold_list[int(len(fold_list)/2)+2: len(fold_list)]

    if len(left_list) > 1:
        paper_fold(left_list)
    elif len(right_list) > 1:
        paper_fold(right_list)
    else:
        print(left_list)
        print(right_list)
        # if left_list[0] != right_list[0]:
        #     return true
        # else:
        #     return false


# 테스트 케이스 개수 입력받기
test_case = input()

for case in range(0, len(test_case)):
    # 종이 접은 목록 문자열 입력받기
    fold_case = input()

    paper_fold(fold_case)

    # if paper_fold(fold_case):
    #     print("YES")
    # else:
    #     print("NO")
