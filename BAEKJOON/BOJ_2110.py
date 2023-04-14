import sys
input = sys.stdin.readline

n, m = map(int, input().split())

homes = []
for _ in range(n):
    temp = int(input().rstrip())
    homes.append(temp)
homes = sorted(homes)
start = 1
end = homes[n-1] - homes[0]
result = 0
while start <= end:
    mid = (start + end) // 2
    count = 1
    value = homes[0]
    for i in range(1, n):
        if homes[i]-value >= mid:
            value = homes[i]
            count += 1
    if count >= m:
        start = mid + 1
        result = mid
    else:
        end = mid - 1

print(result)