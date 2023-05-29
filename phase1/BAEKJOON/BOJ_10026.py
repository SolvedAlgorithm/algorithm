def main():
    n = int(input())
    RGB = []

    for i in range(n):
        input_list = input()
        RGB.append(input_list)
    visited = [[True for i in range(n)] for j in range(n)]

    result = 0
    for i in range(n):
        for j in range(n):
            result += bfs(RGB, i, j, n, visited)

    table = str.maketrans('G','R')
    for i in range(n):
        RGB[i] = RGB[i].replace('G', 'R')
    visited = [[True for i in range(n)] for j in range(n)]
    RGresult = 0
    for i in range(n):
        for j in range(n):
            RGresult += bfs(RGB, i, j, n, visited)
    print(result, end=" ")
    print(RGresult)


def bfs(RGB, x, y, n, visited):
    idx_x = [-1, 0, 1, 0]
    idx_y = [0, -1, 0, 1]

    if visited[x][y]:
        q = [(x, y)]
        visited[x][y] = False

        while q:
            pop = q.pop()
            for i in range(4):
                X = pop[0] + idx_x[i]
                Y = pop[1] + idx_y[i]
                if X < 0 or X >= n or Y < 0 or Y >= n:
                    continue

                if visited[X][Y] and RGB[x][y] == RGB[X][Y]:
                    q.append((X, Y))
                    visited[X][Y] = False
        return 1
    else:
        return 0

main()