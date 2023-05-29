import sys

input = sys.stdin.readline

n = int(input())
crane = list(map(int, input().split()))
m = int(input())
box = list(map(int, input().split()))
crane.sort(reverse=True)
box.sort(reverse=True)
if crane[0] < box[0]:
    print(-1)
else:
    position = [0] * n
    move = [False for _ in range(m)]
    time = 0
    num = m
    while num > 0:
        for i in range(n):
            while position[i] < m:
                if not move[position[i]] and crane[i] >= box[position[i]]:
                    move[position[i]] = True
                    position[i] += 1
                    num -= 1
                    break
                position[i] += 1
        time += 1
    print(time)
