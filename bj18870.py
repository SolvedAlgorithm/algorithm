import sys
input = sys.stdin.readline
N = int(input())
num = list(map(int, input().split()))
setN = list(set(num))
setN = sorted(setN)

number = {}
idx = 0
for n in setN:
    number[n] = idx
    idx += 1
for i in range(N):
    print(number.get(num[i]), end=" ")