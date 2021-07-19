import sys
input = sys.stdin.readline
def main():
    i = 0
    while True:
        L, P, V = map(int, input().split())

        if L == 0 and P == 0 and V == 0:
            break
        i+=1
        a = V // P

        b = (V - P * a)
        if L < b:
            b = L

        result = a * L + b
        print("Case %d: %d"%(i, result))

main()