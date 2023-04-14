import sys
input = sys.stdin.readline

def answer(n, x, y):
    global result
    if n == 2:
        if x == r and y == c:
            print(int(result))
            return
        result += 1
        if x == r and y + 1 == c:
            print(int(result))
            return
        result += 1
        if x + 1 == r and y == c:
            print(int(result))
            return
        result += 1
        if x + 1 == r and y+1 == c:
            print(int(result))
            return
        result += 1
        return
    if (x <= r and r < x + n//2) and ( y <= c and c < y + n//2):
        answer(n//2, x, y)
    else:
        result += (n//2) **2
    if (x <= r and r < x + n // 2) and (y + n//2<= c and c < y + n):
        answer(n//2, x, y + n//2)
    else:
        result += (n//2) **2
    if (x + n//2<= r and r < x + n) and (y <= c and c < y + n // 2):
        answer(n/2, x + n//2, y)
    else:
        result += (n//2) **2
    if (x +n//2<= r and r < x + n) and (y +n//2<= c and c < y + n):
        answer(n//2, x + n//2, y + n//2)
    else:
        result += (n//2) **2

result = 0
m, r, c = map(int, input().split())
answer(2 ** m, 0,0)