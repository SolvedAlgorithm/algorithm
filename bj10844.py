def main():
    n = int(input())
    stairN = [[0 for _ in range(10)] for _ in range(n+1)]
    stairN[1] = [0,1,1,1,1,1,1,1,1,1]

    for i in range(2,n+1):
        for j in range(10):
            temp = stairN[i-1][j]
            if j == 0:
                stairN[i][j+1]+=temp
            elif j == 9:
                stairN[i][j-1] += temp
            else:
                stairN[i][j+1] += temp
                stairN[i][j-1] += temp

    result = 0
    for i in stairN[n]:
        result += i
    result = result % 1000000000
    print(result)


main()