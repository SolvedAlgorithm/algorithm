import sys
input = sys.stdin.readline
def main():
    n = int(input())

    given = []
    for i in range(n):
        given.append(int(input()))

#    sorted = quick(given)
    given.sort()
    answer = 0
    for i in range(1,n+1):
        dissatisfaction = abs(i-given[i-1])

        answer += dissatisfaction
    print(answer)

def quick(data):
    if len(data) <= 1:
        return data
    left = []
    right = []
    pivot = data[0]
    for i in range(1,len(data)):
        if pivot > data[i]:
            left.append(data[i])
        else:
            right.append(data[i])

    return quick(left) + [pivot] + quick(right)
main()