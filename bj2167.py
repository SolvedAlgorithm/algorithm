N, M = map(int, input().split())
temp = [list(map(int, input().split())) for _ in range(N)]
arr =[[0 for _ in range(M)] for _ in range(N)]

for i in range(N):
    for j in range(M):
        arr[i][j] += temp[i][j]
        if i-1 >= 0:
            arr[i][j] += arr[i-1][j]
        if j-1 >= 0:
            arr[i][j] += arr[i][j-1]
        if i-1 >= 0 and j-1 >= 0:
            arr[i][j] -= arr[i-1][j-1]

def SUM(a, b, x, y, arr):
    sum = arr[x][y]
    if a-1 >= 0 and b-1 >= 0:
        sum += arr[a-1][b-1]
    if b-1 >= 0:
        sum -= arr[x][b-1]
    if a-1 >= 0:
        sum -= arr[a-1][y]
    return sum

case = int(input())
for _ in range(case):
    a, b, x, y = map(int, input().split())
    print(SUM(a-1, b-1, x-1, y-1, arr))
