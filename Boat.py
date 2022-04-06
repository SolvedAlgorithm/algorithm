from collections import deque
def solution(people, limit):
    answer = 0
    people = sorted(people)
    people = deque(people)
    
    while people:
        a = people.pop()
        if a > limit - 40:
            answer += 1
        else:
            people.append(a)
            break
    while people:
        if len(people) == 1:
            answer += 1
            break
        Min = people.popleft()
        Max = people.pop()
        if Min+Max > limit:
            people.appendleft(Min)
            answer += 1
        else:
            answer += 1
                
    return answer
