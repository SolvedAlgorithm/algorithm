import heapq

N, L = map(int, input().split())
hole = [(0, 0) for _ in range(N)]

for i in range(N):
    s, e = map(int, input().split())
    hole[i] = (s, e)
    
heapq.heapify(hole)

fence = 0
answer = 0
while hole:
    start, end = heapq.heappop(hole)
    start = max(fence, start)
    fence = start
    if start >= end:
        continue
    else:
        temp = (end - start) // L
        if (end - start) % L != 0:
            temp += 1
        answer += temp
        fence += temp * L 
print(answer)
