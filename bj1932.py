N = int(input())
triangle = [list(map(int, input().split())) for _ in range(N)]
tMax = -1
if N == 1: tMax = triangle[0][0]
else:
    for i in range(1, N):
        length = len(triangle[i])
        for j in range(length):
            if j == 0: triangle[i][j] += triangle[i-1][j]
            elif j == length - 1: triangle[i][j] += triangle[i-1][j-1]
            else: triangle[i][j] += max(triangle[i-1][j], triangle[i-1][j-1])
        tMax = max(triangle[i])  
print(tMax)