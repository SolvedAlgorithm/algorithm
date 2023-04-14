import heapq
INF = int(1e9)
testcase = int(input())

def dijkstra(start):
    queue = []
    distance = [INF for _ in range(n+1)]

    heapq.heappush(queue, (0, start))
    distance[start] = 0

    while queue:
        dist, node = heapq.heappop(queue)
        if distance[node] < dist:
            continue
        for a, s in graph[node]:
            cost = dist + s
            if distance[a] > cost:
                distance[a] = cost
                heapq.heappush(queue, (cost, a))

    result = []
    for i in distance:
        if i != INF:
            result.append(i)
    print(len(result), max(result))
for _ in range(testcase):
    n, d, c = map(int, input().split())
    graph = [[] for _ in range(n+1)]

    for _ in range(d):
        a, b, s = map(int, input().split())
        graph[b].append((a, s))
    dijkstra(c)

