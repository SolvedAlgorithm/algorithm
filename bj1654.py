def main():
    k, n = map(int, input().split())

    data = []
    check = False
    for _ in range(k):
        temp = int(input())
        if len(data) != 0 and data[0] != temp:
            check = True
        data.append(temp)
    if n == 1 and k == 1:
        print(data[0])
    elif not check and len(data) > 1:
        print(data[0])
    else:
        maxN = max(data)
        print(BinarySearch(data, 0, maxN, n))

def BinarySearch(data, start, end, n):
    binary = (start + end) // 2
    if start + 1 == end:
        return binary
    temp = 0
    for i in data:
        temp += i // binary
    if temp < n:
        return BinarySearch(data, start, binary,n)
    else:
        return BinarySearch(data,binary, end,n)
main()