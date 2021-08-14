n = int(input())

array = list(map(int, input().split()))

result = [1 for _ in range(n)]

for i in range(1, n):
    for j in range(0, i):
        if array[j] < array[i]:
            result[i] = max(result[j]+1, result[i])
print(max(result))