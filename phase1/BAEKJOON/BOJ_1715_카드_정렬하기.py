import heapq

n = int(input())

cards = []

for _ in range(n):
    temp = int(input())
    heapq.heappush(cards, temp)

result = 0
if len(cards) == 1:
    print(0)
else:
    while cards:
        first = heapq.heappop(cards)
        second = heapq.heappop(cards)
        fs = first + second
        result += fs

        if len(cards) != 0:
            heapq.heappush(cards, fs)
    print(result)