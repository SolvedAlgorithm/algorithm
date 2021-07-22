import sys
from collections import deque


def main():
    r, c = map(int, input().split())
    graph = []
    visit = [[False for _ in range(c)] for _ in range(r)]

    for _ in range(r):
        temp = input()
        graph.append(temp)
    result_o = 0
    result_v = 0
    for i in range(r):
        for j in range(c):
            if graph[i][j] == "#":
                continue
            if visit[i][j] == True:
                continue
            o, v = bfs(i,j,graph,r,c,visit)
            if o > v:
                result_o += o
            else:
                result_v += v
    print(result_o, end=' ')
    print(result_v)


def bfs(a, b, graph, r, c, visit):
    q = deque()
    q.append([a,b])
    visit[a][b] = True

    aIdx = [0,1,0,-1]
    bIdx = [1,0,-1,0]
    returnO = 0
    returnV = 0
    if graph[a][b] == "o":
        returnO += 1
    if graph[a][b] == "v":
        returnV += 1
    while q:
        A,B = q.popleft()
        for i in range(4):
            tempA = A + aIdx[i]
            tempB = B + bIdx[i]
            if tempA < 0 or tempB < 0 or tempA >= r or tempB >= c:
                continue

            if visit[tempA][tempB] == False and graph[tempA][tempB] != "#":
                q.append((tempA, tempB))
                visit[tempA][tempB] = True
                if graph[tempA][tempB] == "o":
                    returnO += 1
                if graph[tempA][tempB] == "v":
                    returnV += 1
    return returnO, returnV
main()