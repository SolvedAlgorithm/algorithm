import heapq
answer = 0
n, k = map(int, input().split());
nation = []
for i in range(n):
    idx, gold, silver, bronze = map(int, input().split())
    nation.append(((-1)*gold, (-1)*silver, (-1)*bronze, idx))
    
heapq.heapify(nation)
g, s, b, cnt = -1, -1, -1, 1

while nation:
    a = heapq.heappop(nation)
    answer += 1
    if g == a[0] and s == a[1] and b == a[2]:
        cnt += 1
    else:
        cnt = 1
        
    if a[3] == k:
        answer -= cnt - 1
        break
    g, s, b = a[0], a[1], a[2]
    
print(answer)
    