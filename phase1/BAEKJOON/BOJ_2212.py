import sys
import heapq
input = sys.stdin.readline

n = int(input())
k = int(input())
if k >= n:
    print(0)
    sys.exit()
center = list(map(int, input().split()))
center.sort()


distance = []
for i in range(1, len(center)):
    temp = center[i] - center[i-1]
    distance.append(temp)

distance.sort(reverse=True)
for i in range(k-1):
    distance[i] = 0
print(sum(distance))



