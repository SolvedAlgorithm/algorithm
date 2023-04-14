testcase = int(input())

def spin(N, d, Map):
    newMap = [[Map[i][j] for j in range(N)] for i in range(N)]
    
    idx = N-1
    halfN = N // 2
    for k in range(halfN+1):
        if k == idx:
            continue
        tpK = (k + idx)//2
        temp = [(0, 0) for _ in range(8)]
        temp[0] = (k, k)
        temp[1] = (k, tpK)
        temp[2] = (k, idx)
        temp[3] = (tpK, idx)
        temp[4] = (idx, idx)
        temp[5] = (idx, tpK)
        temp[6] = (idx, k)
        temp[7] = (tpK, k)
        for i in range(8):
            spIX = i + d
            if d < 0 and spIX < 0:
                spIX += 8
            if d >= 0 and spIX >= 8:
                spIX %= 8
            newMap[temp[spIX][0]][temp[spIX][1]] = Map[temp[i][0]][temp[i][1]]
            
        idx -= 1
    return newMap

for t in range(testcase):
    n, D = map(int, input().split())
    MAP = [list(map(int, input().split())) for _ in range(n)]
    newMAP = spin(n, (D//45), MAP)

    for i in range(n):
        for j in range(n):
            print(newMAP[i][j], end=" ")
        print("")

