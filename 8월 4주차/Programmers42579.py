def solution(genres, plays):
    answer = []

    totalPlays = {}
    genreDict = {}

    for i in range(len(genres)):
        if genres[i] not in genreDict.keys():
            genreDict[genres[i]] = [(plays[i], i)]
            totalPlays[genres[i]] = plays[i]
        else:
            genreDict[genres[i]].append((plays[i], i))
            totalPlays[genres[i]] += plays[i]

    sortTotalPlays = sorted(totalPlays.items(), key=lambda x: x[1], reverse=True)

    for key in sortTotalPlays:
        playList = genreDict[key[0]]
        playList = sorted(playList, key=lambda x: (-x[0], x[1]))

        for i in range(len(playList)):
            if i == 2:
                break
            answer.append(playList[i][1])

    return answer