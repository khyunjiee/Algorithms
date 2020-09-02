def solution(clothes):
    answer = 1
    answer_dict = {}

    for i, kind in clothes:
        if kind not in answer_dict:
            answer_dict[kind] = 1
        else:
            answer_dict[kind] += 1

    for val in answer_dict.values():
        answer *= (val+1)

    return answer-1

solution([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]])
solution([["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]])
