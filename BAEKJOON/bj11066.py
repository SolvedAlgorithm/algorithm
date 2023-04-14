testcase = int(input())

def ans(N, files):
    S = [0 for _ in range(N+1)]
    for i in range(1, N+1):
        S[i] = S[i-1] + files[i]
        
    DP = [[0 for _ in range(N+1)] for _ in range(N+1)]
    
    for i in range(2, N+1):
        for j in range(1, N-i+2):
            DP[j][i+j-1] = min([DP[j][k] + DP[k+1][i+j-1] for k in range(j, i+j-1)]) + S[i+j-1] - S[j-1]

    return DP[1][N]

for i in range(testcase):
    N = int(input())
    files = [0] + list(map(int, input().split()))
    print(ans(N, files))
    
    