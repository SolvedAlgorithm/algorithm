import sys
input = sys.stdin.readline

a, b = map(int, input().split())
arrayA = list(map(int, input().split()))
arrayB = list(map(int, input().split()))

idxA = 0
idxB = 0
while(idxA != a or idxB != b):
    if idxA == a:
        for i in range(idxB, b):
            print(arrayB[i], end=" ")
        break
    if idxB == b:
        for i in range(idxA, a):
            print(arrayA[i], end=" ")
        break

    if arrayA[idxA] < arrayB[idxB]:
        print(arrayA[idxA], end=" ")
        idxA+=1
    else:
        print(arrayB[idxB], end=" ")
        idxB+=1
