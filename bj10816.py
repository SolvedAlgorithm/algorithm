import sys
input = sys.stdin.readline

n = int(input())
temp = list(map(int, input().split()))
card = {}
for i in range(n):
    card[temp[i]] = card.setdefault(temp[i], 0)
    card[temp[i]] += 1
m = int(input())
check = list(map(int, input().split()))

number = sorted(card)
start = 0
end = len(number) -1
answer = [0 for _ in range(m)]
for i in range(m):
    chk = check[i]
    while start <= end:
        mid = (start + end) // 2
        if number[mid] > chk:
            end = mid - 1
        elif number[mid] == chk:
            answer[i] = card.get(number[mid])
            break
        else:
            start = mid + 1
    start = 0
    end = len(number) -1
for ans in answer:
    print(ans, end=" ")