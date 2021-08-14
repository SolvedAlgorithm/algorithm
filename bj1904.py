n = int(input())

first = 1
second = 2
if n < 3:
    print(n)
else:

    result = 0
    for i in range(3, n+1):
        result = (first + second) % 15746
        first = second
        second = result
    print(result)