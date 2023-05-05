import heapq
INF = int(1e9)
def solution(n, edge):
    answer = 0
    path = [INF for _ in range(n+1)]
    graph = [[] for _ in range(n+1)]
    length = len(edge)
    for i in range(length):
        graph[edge[i][0]].append(edge[i][1])
        graph[edge[i][1]].append(edge[i][0])
        
    q = []
    heapq.heappush(q, (0, 1))
    path[1] = 0
    while(q):
        pop = heapq.heappop(q)
        if path[pop[1]] < pop[0]:
            continue
        for num in graph[pop[1]]:
            if path[num] > pop[0] + 1:
                path[num] = pop[0] + 1
                heapq.heappush(q, (pop[0] + 1, num))
    maxN = -1  
    for n in path:
        if n != INF:
            if n > maxN:
                maxN = n
                answer = 1
            elif n == maxN:
                answer += 1
            
    
    return answer