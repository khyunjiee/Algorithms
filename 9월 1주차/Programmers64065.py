def solution(s):
    answer = []
    s = s[2:-2]
    strlist = s.split("},{")
    strlist.sort(key=len)

    for s in strlist:
        ss = s.split(",")
        for i in ss:
            if int(i) not in answer:
                answer.append(int(i))

    return answer

print(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"))
print(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"))
print(solution("{{20,111},{111}}"))
print(solution("{{123}}"))
print(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"))



