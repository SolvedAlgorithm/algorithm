def solution(N, number):
    if N == number:
        return 1
    answer = operate(N, number)
    return answer

def operate(N, number):
    total = []
    count = [[] for _ in range(9)]
    chk = [[], [], [1, 1], [1, 2], [1, 3, 2,2], [1, 4, 2,3],[1, 5, 2,4,3,3], [1, 6,2,5,3, 4], [1,7,2,6,3,5,4,4]]
    
    total.append(N)
    count[1].append(N)
    
    for use in range(2, 9):
        temp = N
        for i in range(1, use):
            temp += (10**i)*N
        if temp == number:
            return use
        count[use].append(temp)
        total.append(temp)
        for pn in count[use-1]:
            pnList = []
            pnList.append(pn-N)
            pnList.append(pn+N)
            pnList.append(pn*N)
            pnList.append(pn//N)
            
            for i in range(4):
                if pnList[i] == number: 
                    return use
                if pnList[i] > 0 and pnList[i] <= 32000 and (pnList[i] not in total):
                    count[use].append(pnList[i])
                    total.append(pnList[i])
        length = len(chk[use])
        if length > 0:
            for i in range(0, length, 2):
                for j in count[chk[use][i]]:
                    for k in count[chk[use][i+1]]:
                        chkList = []
                        chkList.append(k+j)
                        chkList.append(k-j)
                        chkList.append(j-k)
                        chkList.append(k*j)
                        chkList.append(k//j)
                        chkList.append(j//k)
                        for p in range(6):
                            if chkList[p] == number:
                                return use
                            if chkList[p] > 0 and chkList[p] <= 32000 and (chkList[p] not in total):
                                count[use].append(chkList[p])
                                total.append(chkList[p])
    return -1