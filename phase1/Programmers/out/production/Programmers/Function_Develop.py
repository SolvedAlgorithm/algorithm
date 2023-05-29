from collections import deque
def solution(progresses, speeds):
    answer = []
    works = deque(progresses)
    doing = deque(speeds)
    
    idx = 0
    num = 0
    while works:
        popWork = 100 - works.popleft()
        popDoing = doing.popleft()
        check = popWork - idx * popDoing
        if check > 0:
            if idx != 0:
                answer.append(num)
            num = 1
            days = check // popDoing
            temp = check % popDoing
            if temp != 0:
                days += 1
            idx += days
        else:
            num += 1
    answer.append(num)
    return answer