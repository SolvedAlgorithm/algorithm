import heapq
INF = int(1e9)

def main():
    n, m, k = map(int, input().split())
    graph = [[]for _ in range(n+1)]

    for i in range(m):
        a, b, c = map(int, input().split())
        graph[a].append((c, b))

    temp = [[] for _ in range(n+1)]
    for i in range(1, n+1):
        temp[i] = dijkstra(i, graph, n)

    max = 0
    for i in range(1, n+1):
        sum = temp[i][k] + temp[k][i]
        if max < sum:
            max = sum
    print(max)


def dijkstra(start, graph, n):
    distance = [INF] * (n+1)

    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:

        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[0]
            if cost < distance[i[1]]:
                distance[i[1]] = cost
                heapq.heappush(q, (cost, i[1]))
    return distance

main()


