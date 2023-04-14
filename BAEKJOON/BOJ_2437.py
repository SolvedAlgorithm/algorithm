N = int(input())
weights = list(map(int, input().split()))
weights.sort()

ans = 0

for w in weights:
    if w <= ans+1:
        ans += w
    else:
        break
print(ans+1)
