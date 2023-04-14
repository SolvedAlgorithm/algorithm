import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
queue = deque()

for i in range(n):
    temp = input().split()
    if len(temp) == 2:
        queue.append(int(temp[1]))
    else:
        if temp[0] == "pop":
            if len(queue) == 0:
                print(-1)
            else:
                print(queue.popleft())
        elif temp[0] == "size":
            print(len(queue))
        elif temp[0] == "empty":
            if len(queue) == 0:
                print(1)
            else:
                print(0)
        elif temp[0] == "front":
            if len(queue) == 0:
                print(-1)
            else:
                a = queue.popleft()
                print(a)
                queue.appendleft(a)
        elif temp[0] == "back":
            if len(queue) == 0:
                print(-1)
            else:
                a = queue.pop()
                print(a)
                queue.append(a)
