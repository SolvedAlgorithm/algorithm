import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)
def main():
    n, m = map(int, input().split())
    graph = [[] for _ in range(n+1)]

    for _ in range(m):
        start, end, cost = map(int, input().split())
        graph[start].append((end, cost))
        graph[end].append((start, cost))

    homeNum, convNum = map(int, input().split())

    home = list(map(int, input().split()))
    convenience = list(map(int, input().split()))

    short = []
    for i in home:
        short.append(dijkstra(graph, i, n))

    result = []
    min = INF
    for i in range(homeNum):
        for j in convenience:
            if min > short[i][j]:
                min = short[i][j]

    for i in range(homeNum):
        for j in convenience:
            if min == short[i][j]:
                result.append(home[i])

    result.sort()
    print(result[0])

def dijkstra(graph, start, n):
    distance = [INF] * (n+1)

    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]

            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    return distance

main()