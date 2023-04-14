from collections import deque
n = int(input())
number = [i for i  in range(1, n+1)]
number = deque(number)

while len(number) != 1:
    number.popleft()
    temp = number.popleft()
    number.append(temp)

print(number[0])
