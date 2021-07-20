from collections import deque
import sys
input = sys.stdin.readline
INF = int(1e9)
def main():
    n, m = map(int, input().split())
    graph = [[] for _ in range(n+1)]

    for _ in range(m):
        end, start = map(int, input().split())
        graph[start].append(end)

    max = 0
    answer = [0] * (n+1)
    for i in range(1, n+1):
        temp = bfs(i, graph, n)
        answer[i] = temp
        if max < temp:
            max = temp
    for i in range(1, n+1):
        if max == answer[i]:
            print(i, end=' ')

def bfs(begin, graph, n):
    visit = [False] * (n+1)
    q = deque()
    visit[begin] = True
    q.append(begin)
    result = 0
    while q:
        temp = q.popleft()
        result+=1
        for i in graph[temp]:
            if not visit[i]:
                q.append(i)
                visit[i] = True
    return result

main()