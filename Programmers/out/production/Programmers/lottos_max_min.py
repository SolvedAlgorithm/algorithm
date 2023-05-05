def solution(lottos, win_nums):
    lottos = sorted(lottos)
    win_nums = sorted(win_nums)
    zero = 0
    idx = 0
    same = 0;
    for l in range(6):
        if lottos[l] == 0:
            zero+=1
        else:
            idx = l
            break
    for i in range(6):
        if idx == 6:
            break
        if win_nums[i] == lottos[idx]:
            same+=1
            idx+=1
        elif win_nums[i] > lottos[idx]:
            idx += 1
            while True:
                if idx== 6:
                    break
                if win_nums[i] > lottos[idx]:
                    idx+=1
                elif win_nums[i] == lottos[idx]:
                    same+=1
                    idx+=1
                    break
                else:
                    break
            
    min_rank = 6 - same + 1
    max_rank = 6 - (same + zero) + 1
    answer = [0, 0]
    if min_rank > 5:
        answer[1] = 6
    else:
        answer[1] = min_rank
    
    if max_rank > 5:
        answer[0] = 6
    else:
        answer[0] = max_rank
    return answer