import heapq

n = int(input())

brick = []
brick.append((0,0,0,0))

for i in range(1, n+1):
    area, height, weight = map(int, input().split())
    brick.append((i, area, height, weight))

brick.sort(key=lambda data: data[1]) #1번째 값인 area를 기준으로 sort

result_height = [0 for _ in range(n+1)]
result_bricks = []

for i in range(1, n+1):
    for j in range(i):
        if brick[i][3] > brick[j][3]:
            result_height[i] = max(result_height[i], result_height[j] + brick[i][2])
max_height = max(result_height)

index = n
while index != 0:
    if max_height == result_height[index]:
        result_bricks.append(brick[index][0])
        max_height -= brick[index][2]
    index -= 1

length = len(result_bricks)

print(length)

for i in range(length-1, -1, -1):
    print(result_bricks[i])