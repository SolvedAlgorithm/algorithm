# 0분에 어떤 지점에 도착할 수 있는 경우의 수가 초기값
#[정보, 전산, 미래, 신양, 한경, 진리, 형남, 학생회]
paths = [1, 0, 0, 0, 0, 0, 0, 0]
neighbor =[[1, 2], [0,2,3], [0,1,3,4], [1,2,4,5], [2,3,5,6], [3,4,7], [4,7], [5,6]]

N = int(input())

for n in range(N):
    newPaths = [0 for _ in range(8)]
    for i in range(8):
        if paths[i] == 0: continue
        for nb in neighbor[i]:
            newPaths[nb] += paths[i]
    # for i in range(8):
    #     newPaths[i] %= 1000000007
    paths = newPaths
    
print(paths[0] % 1000000007)    
# print(paths[0])