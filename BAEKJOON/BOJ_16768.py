from collections import deque

N, K = map(int, input().split())
Map = [[0 for _ in range(10)] for _ in range(N)]
visit = [[False for _ in range(10)] for _ in range(N)]

for i in range(N):
    temp = input()
    for j in range(10):
        Map[i][j] = int(temp[j])
        if Map[i][j] == 0:
            visit[i][j] = True

def visited():
    for i in range(N):
        for j in range(10):
            if Map[i][j] == 0:
                visit[i][j] = True
            else:
                visit[i][j] = False

def zero(coordinate):
    for a, b in coordinate:
        Map[a][b] = 0
        visit[a][b] = True

def bfs(i, j, chk, N, K):
    di = [1, -1, 0, 0]
    dj = [0, 0, 1, -1]
    q = deque([(i, j)])
    coordinate = []
    while q:
        mi, mj = q.popleft()
        for k in range(4):
            newI = mi + di[k]
            newJ = mj + dj[k]
            if newI >= N or newJ >= 10 or newI < 0 or newJ < 0:
                continue
            if not visit[newI][newJ] and Map[newI][newJ] == chk:
                q.append((newI, newJ))
                coordinate.append((newI, newJ))
                visit[newI][newJ] = True
    if len(set(coordinate)) >= K:
        zero(coordinate)
def down(N):
    check = True
    newMap = [[0 for _ in range(10)] for _ in range(N)]
    for j in range(10):
        idx = N-1
        for i in range(N-1, -1, -1):
            if Map[i][j] == 0:
                continue
            if idx == i:
                idx -= 1
                newMap[i][j] = Map[i][j]
                continue
            check = False
            newMap[idx][j] = Map[i][j]
            idx -= 1
    if check:
        return Map, check  
    return newMap, check

        
while True:
    for i in range(N):
        for j in range(10):
            if visit[i][j]:
                continue
            chk = Map[i][j]
            bfs(i, j, chk, N, K)
    Map, check = down(N)
    if check:
        break
    visited()
            
for i in range(N):
    for j in range(10):
        print(Map[i][j], end="")
    print("")
