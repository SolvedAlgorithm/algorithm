import sys
from collections import deque

input = sys.stdin.readline
def main():
    n, m = map(int, input().split())

    graph = []
    visit = [[True for _ in range(m)] for _ in range(n)]

    for i in range(n):
        temp = list(map(int, input().split()))
        graph.append(temp)
        for j in range(m):
            if temp[j] == 1:
                visit[i][j] = False
    result = 0
    for i in range(n):
        for j in range(m):
            if visit[i][j]:
                continue
            result += bfs(i, j, graph, visit, n, m)
    print(result)

def bfs(x, y, graph, visit, n, m):
    q = deque()
    visit[x][y] = True
    q.append((x,y))
    xL = [-1,-1,-1,0,0,1,1,1]
    yL = [-1, 0, 1, -1, 1, -1, 0, 1]
    while q:
        popX, popY = q.popleft()
        for i in range(8):
            tempX = popX + xL[i]
            tempY = popY + yL[i]
            if tempX < 0 or tempY < 0 or tempX >= n or tempY >= m:
                continue
            if not visit[tempX][tempY]:
                q.append((tempX, tempY))
                visit[tempX][tempY] = True
    return 1

main()