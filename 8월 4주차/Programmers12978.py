from queue import PriorityQueue

def bfs(road, N):
    INF = 987654321
    dist = [INF for i in range(N+1)]
    road.sort()
    pq = PriorityQueue()
    pq.put([0, 1])
    dist[1] = 0

    while not pq.empty():
        cost, here = pq.get()
        if cost > dist[here]: continue
        for i in range(len(road)):
            if road[i][0] == here:
                there, nextCost = road[i][1], road[i][2]+cost
                if nextCost < dist[there]:
                    dist[there] = nextCost
                    pq.put([nextCost, there])
            elif road[i][1] == here:
                there, nextCost = road[i][0], road[i][2]+cost
                if nextCost < dist[there]:
                    dist[there] = nextCost
                    pq.put([nextCost, there])
    return dist

def solution(N, road, K):
    answer = 0
    dist = bfs(road, N)

    for d in dist:
        if d <= K:
            answer += 1

    return answer

solution(5, [[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]], 3)
solution(6, [[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]], 4)