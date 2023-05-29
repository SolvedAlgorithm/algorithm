import heapq
import sys
input = sys.stdin.readline

n = int(input())

dead_num = []

queue = []
for _ in range(n):
    deadline, number = map(int, input().split())
    dead_num.append((deadline, number))
dead_num.sort()

for i in range(n):
    heapq.heappush(queue, dead_num[i][1])
    if dead_num[i][0] < len(queue):
        heapq.heappop(queue)
print(sum(queue))