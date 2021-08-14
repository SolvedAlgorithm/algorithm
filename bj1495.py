n, s, m = map(int, input().split())

music = list(map(int, input().split()))

dp = [[0] * (m+1) for _ in range(n+1)]
dp[0][s] = True

for i in range(1, n+1):
    for j in range(m+1):
        if not dp[i-1][j]:
            continue
        if j - music[i-1] >= 0:
            dp[i][j-music[i-1]] = True
        if j + music[i-1] <= m:
            dp[i][j+music[i-1]] = True

result = -1
for i in range(m, -1, -1):
    if dp[n][i]:
        result = i
        break
print(result)

def main():
    n, s, m = map(int, input().split())

    music = list(map(int, input().split()))

    result = [s]
    for i in range(n):
        temp = []
        for old in result:
            plus = old + music[i]
            minus = old - music[i]
            if plus <= m:
                temp.append(plus)
            if minus >= 0:
                temp.append(minus)
        temp = set(temp)
        result = temp
    if len(result) == 0:
        print(-1)
    else:
        print(max(result))

def main2():
    n, s, m = map(int, input().split())

    music = list(map(int, input().split()))

    check = [False for _ in range(m + 1)]
    check[s] = True

    for i in range(n):
        temp = [False for _ in range(m + 1)]
        for j in range(0, m + 1):
            if check[j]:
                plus = j + music[i]
                minus = j - music[i]
                if plus <= m:
                    temp[plus] = True
                if minus >= 0:
                    temp[minus] = True
        check = temp
    result = -1
    for i in range(m, -1, -1):
        if check[i]:
            result = i
            break
    print(result)