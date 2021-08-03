import heapq

def find(node):
    if parent[node] == node:
        return node
    return find(parent[node])

def union(a, b):
    find_a = find(a)
    find_b = find(b)
    if rank[find_a] > rank[find_b]:
        parent[find_b] = find_a
    elif rank[find_b] > rank[find_a]:
        parent[find_a] = find_b
    else:
        if find_a > find_b:
            parent[find_a] = find_b
            rank[find_b] += 1
        else:
            parent[find_b] = find_a
            rank[find_b] += 1

v, e = map(int, input().split())

graph = []

parent = [i for i in range(v+1)]
rank = [0 for _ in range(v+1)]
for _ in range(e):
    a, b, weight = map(int, input().split())
    heapq.heappush(graph, [weight, a, b])

result = 0

while graph:
    weight, a, b = heapq.heappop(graph)
    if find(a) != find(b):
        union(a, b)
        result += weight


print(result)






