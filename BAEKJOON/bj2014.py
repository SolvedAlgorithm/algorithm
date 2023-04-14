import heapq
import copy
K, N = map(int, input().split())

primes = list(map(int, input().split()))
heap, ck = copy.deepcopy(primes), set()
heapq.heapify(heap)

cnt = 0

while cnt < N:
    popN = heapq.heappop(heap)
    if popN in ck:
        continue
    cnt += 1
    ck.add(popN)
    for i in primes:
        heapq.heappush(heap, popN*i)
        
print(popN)