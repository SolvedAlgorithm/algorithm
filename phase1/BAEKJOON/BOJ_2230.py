import sys
input = sys.stdin.readline
N, M = map(int, input().split())
num = [int(input()) for _ in range(N)]
num = sorted(num)
answer = sys.maxsize

end = 0
for start in range(N):
    if start == end:
        end += 1
    while(end < N and num[end] - num[start] < M):
        end+=1
    if end == N:
        break
    answer = min(answer, num[end]-num[start])
    if answer == M:
        break
print(answer)