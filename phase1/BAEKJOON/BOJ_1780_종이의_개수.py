import sys
input = sys.stdin.readline
n = int(input())
paper = [list(map(int, input().split())) for _ in range(n)]

def same(n_, paper_):
    if n_ == 1:
        return True
    chk = paper_[0][0]
    for i in range(n_):
        for j in range(n_):
            if chk != paper_[i][j]:
                return False
    return True

def answer(n_, paper_):
    cnt = [0, 0, 0]
    if same(n_, paper_):
        cnt[paper_[0][0]] += 1
        return cnt
    tempN = n_ // 3
    for i in range(3):
        arr = paper_[i*tempN : (i+1)*tempN]
        for j in range(3):
            temp = [arr[k][j*tempN : (j+1) * tempN] for k in range(tempN)]
            recursion = answer(tempN, temp)
            cnt = [cnt[i] + recursion[i] for i in range(3)]
    return cnt
result = answer(n, paper)
print(result[-1])
print(result[0])
print(result[1])