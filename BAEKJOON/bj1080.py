N, M = map(int, input().split())

A = [list(input()) for _ in range(N)]
B = [list(input()) for _ in range(N)]

def reverse(x, y):
    for i in range(3):
        for j in range(3):
            A[x+i][y+j] = str("10".index(A[x+i][y+j]))
            
cnt = 0
for i in range(N-2):
    for j in range(M-2):
        if A[i][j] != B[i][j]:
            reverse(i, j)
            cnt += 1
if A != B:
    print(-1)
else:
    print(cnt)