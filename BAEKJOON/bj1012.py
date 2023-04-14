from collections import deque


def bfs(b, a):
    queue = deque()
    queue.append((b,a))
    visit[b][a] = True
    aL = [1, 0, -1, 0]
    bL = [0, 1, 0, -1]
    while queue:
        tb, ta = queue.popleft()
        for i in range(4):
            taL = ta + aL[i]
            tbL = tb + bL[i]
            if taL < 0 or tbL < 0 or taL >= m or tbL >= n:
                continue
            if not visit[tbL][taL] and graph[tbL][taL] == 1:
                queue.append((tbL, taL))
                visit[tbL][taL] = True



testcase = int(input())

for _ in range(testcase):
    m,n,k = map(int, input().split())

    graph = [[0 for _ in range(m)] for _ in range(n)]
    visit = [[True for _ in range(m)] for _ in range(n)]

    for _ in range(k):
        a, b = map(int, input().split())
        graph[b][a] = 1
        visit[b][a] = False


    result = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1 and not visit[i][j]:
                bfs(i, j)
                result += 1
    print(result)
