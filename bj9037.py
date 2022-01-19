def answer(n, candies):
    candies = teacher(n, candies)
    count = 0
    while True:
        if check(n, candies):
            break
        new_candies = [0 for _ in range(n)]
        half_candies = [candies[i]//2 for i in range(n)]
        for i in range(n):
            if i == 0:
                new_candies[i] = candies[i] - half_candies[i] + half_candies[n-1]
            else:
                new_candies[i] = candies[i] - half_candies[i] + half_candies[i-1]
        candies = teacher(n, new_candies)
        count += 1
    return count

def check(n, candies):
    candy_sum = sum(candies)
    candy_avg = candy_sum // n
    for c in candies:
        if c != candy_avg:
            return False
    return True
        
def teacher(n, candies):
    for i in range(n):
        if candies[i] % 2 != 0:
            candies[i] += 1
    return candies
testcase = int(input())

for _ in range(testcase):
    n = int(input())
    candies = list(map(int, input().split()))
    print(answer(n, candies))
