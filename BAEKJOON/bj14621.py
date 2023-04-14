import heapq
import sys
input = sys.stdin.readline

def find(node):
    if node == parent[node]:
        return node
    else:
        return find(parent[node])

def union(a, b):
    findA = find(a)
    findB = find(b)

    if parent[findA] != parent[findB]:
        if rank[findA] < rank[findB]:
            parent[findA] = findB
        elif rank[findB] < rank[findA]:
            parent[findB] = findA
        else:
            if findA > findB:
                parent[findA] = findB
                rank[findB] += 1
            else:
                parent[findB] = findA
                rank[findA] += 1

n, m = map(int, input().split())
mw = list(map(str, input().split()))

queue = []
for _ in range(m):
    a, b, dist = map(int, input().split())
    heapq.heappush(queue,[dist, a, b])

parent = [i for i in range(n+1)]
rank = [0 for i in range(n+1)]
result = 0
while queue:
    dist, a, b = heapq.heappop(queue)
    if mw[a-1] != mw[b-1]:
        if find(a) != find(b):
            union(a,b)
            result += dist
check = False
for i in range(2, n+1):
    if parent[find(1)] != parent[find(i)]:
        check = True

if check:
    print(-1)
else:
    print(result)
