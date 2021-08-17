from collections import deque
INF = int(1e9)
n, k = map(int, input().split())


def bfs(start):
    visit = [INF for i in range(100001)]
    visit[start] = 0
    queue = deque()
    queue.append(start)
    while queue:
        temp = queue.popleft()
        minus = temp - 1
        plus = temp + 1
        twice = temp * 2

        if minus >= 0:
            if visit[minus] > visit[temp] + 1:
                visit[minus] = visit[temp]+1
                queue.append(minus)
        if plus <= 100000:
            if visit[plus] > visit[temp] + 1:
                visit[plus] = visit[temp] + 1
                queue.append(plus)
        if twice <= 100000:
            if visit[twice] > visit[temp] + 1:
                visit[twice] = visit[temp] + 1
                queue.append(twice)
    print(visit[k])
bfs(n)