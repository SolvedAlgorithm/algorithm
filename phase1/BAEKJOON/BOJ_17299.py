n = int(input())
A = list(map(int, input().split()))
cnt = {}
for i in range(n):
    cnt.setdefault(A[i], 0)
    cnt[A[i]] += 1
A = [(A[i], cnt[A[i]]) for i in range(n)]
stack = []
answer = [-1] * n
for i in range(n-1, -1, -1):
    if len(stack) != 0:
        while stack[-1][1] <= A[i][1]:
            stack.pop()
            if len(stack) == 0:
                break
        if len(stack) != 0:
            answer[i] = stack[-1][0]
    stack.append(A[i])

print(*answer)