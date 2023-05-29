N = int(input())

loop = {}
for i in range(N):
    t = int(input())
    if t in loop:
        loop[t] = loop.get(t) + 1
    else:
        loop[t] = 1

sort_loop = sorted(loop.items(), key = lambda item : item[0])

maxWeight = sort_loop[0][0] * N
cnt = N
for key, value in sort_loop:
    if cnt == N:
        cnt -= value
        continue
    chk = key * cnt
    if chk > maxWeight :
        maxWeight = chk
    cnt -= value         
    
print(maxWeight)