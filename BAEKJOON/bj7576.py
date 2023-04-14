import sys
input = sys.stdin.readline
m, n = map(int, input().split())

graph = [[] for _ in range (n)]
tomato = []
tomatoN = 0
sweet = 0
for i in range(n):
    graph[i] = list(map(int, input().split()))
    for j in range(m):
        if graph[i][j] == 1:
            tomato.append((i, j))
            graph[i][j] = -1
            tomatoN += 1
            sweet += 1
        elif graph[i][j] == 0:
            tomatoN += 1

if sweet == tomatoN:
    print(0)
    sys.exit()

iL = [-1, 0, 1, 0]
jL = [0, -1, 0, 1]

result = 0
while len(tomato) > 0:
    if sweet == tomatoN:
        break
    result += 1
    temp = []
    for i, j in tomato:
        for k in range(4):
            temp_i = i + iL[k]
            temp_j = j + jL[k]
            if temp_i < 0 or temp_j < 0 or temp_i >= n or temp_j >= m:
                continue
            if graph[temp_i][temp_j] == 0:
                temp.append((temp_i, temp_j))
                graph[temp_i][temp_j] = -1
                sweet += 1

    tomato = temp
if tomatoN != sweet:
    print(-1)
else:
    print(result)