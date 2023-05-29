from copy import deepcopy
N = int(input())
Board = [list(map(int, input().split())) for _ in range(N)]

def rotate90(N, B):
    newB = deepcopy(Board)
    for i in range(N):
        for j in range(N):
            newB[j][N-i-1] = B[i][j]
    return newB
def Left(N, lst):
    newL = [i for i in lst if i > 0]
    for i in range(1, len(newL)):
        if newL[i-1] == newL[i]:
            newL[i-1], newL[i] = newL[i] * 2, 0
    newL = [i for i in newL if i > 0]
    return newL + [0] * (N - len(newL))

def process(N, Board, count):
    ans = max([max(lst) for lst in Board])
    if count == 0:
        return ans
    for i in range(4):
        newBoard = [Left(N, x) for x in Board]
        if newBoard != Board:
            ans = max(ans, process(N, newBoard, count - 1))
        Board = rotate90(N, Board)
    return ans
print(process(N, Board, 5))