N = int(input())
Map = [list(map(int, input().split())) for _ in range(N)]

def checkMap(lst):
    dx = [0, 1, -1, 0, 0]
    dy = [0, 0, 0, 1, -1]
    coordinate = []
    sum = 0
    for n in lst:
        x = n // N
        y = n % N
        for i in range(5):
            newX = x + dx[i]
            newY = y + dy[i]
            if newX >= N or newY >= N or newX < 0 or newY < 0:
                return 10000
            sum += Map[newX][newY]
            coordinate.append((newX, newY))
    if len(set(coordinate)) != 15:
        return 10000
    return sum
ans = 10000
for i in range(N*N):
    for j in range(i, N*N):
        for k in range(j, N*N):
            ans = min(ans, checkMap([i, j, k]))
print(ans)

