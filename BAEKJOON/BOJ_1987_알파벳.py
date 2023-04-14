from collections import deque
import sys

r, c = map(int, input().split())

roadmap = []
for _ in range(r):
    roadmap.append(input())

A = [0, 0, 1, -1]
B = [-1, 1, 0, 0]

def bfs(a, b):
    global result
    q = set()
    q.add((a, b, roadmap[a][b]))

    while q:
        a, b, string = q.pop()
        result = max(result, len(string))

        for i in range(4):
            temp_a = a + A[i]
            temp_b = b + B[i]

            if temp_a >= 0 and temp_a < r and temp_b >= 0 and temp_b < c and roadmap[temp_a][temp_b] not in string:
                q.add((temp_a, temp_b, string + roadmap[temp_a][temp_b]))
result = 0
bfs(0, 0)
print(result)
