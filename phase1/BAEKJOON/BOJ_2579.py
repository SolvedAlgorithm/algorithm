n = int(input())
dp = [[0, 0, 0] for _ in range(n)]
stairs = [int(input()) for _ in range(n)]
if n == 1:
    print(stairs[0])
else:
    dp[0][1] = stairs[0]
    dp[1][1] = stairs[1]
    dp[1][2] = stairs[0] + stairs[1]
    for i in range(2, n):
        dp[i][1] = max(dp[i-2][1], dp[i-2][2]) + stairs[i]
        dp[i][2] = dp[i-1][1] + stairs[i]
    print(max(dp[n-1][1], dp[n-1][2]))
