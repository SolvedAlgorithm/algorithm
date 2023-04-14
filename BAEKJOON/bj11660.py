import sys
input = sys.stdin.readline
n, m = map(int, input().split())

result = [[0 for _ in range(n)] for _ in range(n)]

for i in range(n):
    temp = list(map(int, input().split()))
    value = 0
    for j in range(n):
        if i == 0:
            value += temp[j]
            result[i][j] = value
        else:
            if j == 0:
                result[i][j] = temp[j] + result[i-1][j]
            else:
                result[i][j] = temp[j] + result[i-1][j] + result[i][j-1] - result[i-1][j-1]
idx = []

for _ in range(m):
    temp = list(map(int, input().split()))
    idx.append(temp)

for i in range(m):
    x1, y1, x2, y2  = idx[i]
    x1 = x1 - 1
    y1 = y1 - 1
    x2 = x2 - 1
    y2 = y2 - 1

    if x1 == 0 or y1 == 0:
        if x1 ==0 and y1 ==0:
            print(result[x2][y2])
        else:
            if y1 == 0:
                blueX = x1 - 1
                blueY = y2
                print(result[x2][y2] - result[blueX][blueY])
            else:
                greenX = x2
                greenY = y1 - 1
                print(result[x2][y2] - result[greenX][greenY])
    else:
        pinkX = x1 - 1
        pinkY = y1 - 1
        greenX = x2
        greenY = y1 - 1
        blueX = x1 - 1
        blueY = y2
        print(result[x2][y2] + result[pinkX][pinkY] - result[greenX][greenY] - result[blueX][blueY])
