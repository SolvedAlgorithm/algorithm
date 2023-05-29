import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)
def main():
    n, m, k, x = map(int, input().split())

    dist = [INF for _ in range(n+1)]

    graph = [[] for _ in range(n+1)]

    for i in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)

    q = []
    heapq.heappush(q, (0, x))
    dist[x] = 0

    while q:
        dis, now = heapq.heappop(q)
        if dist[now] < dis:
            continue
        for i in graph[now]:
            cost = dis + 1
            if cost < dist[i]:
                dist[i] = cost
                heapq.heappush(q, (cost, i))
    check = True
    for i in range(n+1):
        if dist[i] == k:
            print(i)
            check = False
    if check:
        print(-1)

main()

