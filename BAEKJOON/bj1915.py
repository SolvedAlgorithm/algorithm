N, M = map(int, input().split())
NMin = min(N, M)

temp = [[0 for _ in range(M)] for _ in range(N)]
for i in range(N):
    str_input = input()
    for j in range(M):
        temp[i][j] = ord(str_input[j]) - ord('0')

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

def rectangle(N, M, NMin, arr):
    if arr[NMin-1][NMin-1] == NMin * NMin:
        return arr[NMin-1][NMin-1]
    NMin -= 1
    while NMin > 0:
        for i in range(N-NMin + 1):
            a, x = i, i + NMin -1
            for j in range(M-NMin + 1):
                b, y = j, j + NMin -1
                sum = SUM(a, b, x, y, arr)
                
                if sum == NMin * NMin:
                    return sum
        NMin -= 1
    return 0  

print(rectangle(N, M, NMin, arr))