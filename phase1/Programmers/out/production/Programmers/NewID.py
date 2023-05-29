import re
def solution(new_id):
    answer = ''
    new_id = new_id.lower()
    temp = re.findall('[\w\_.-]+', new_id)
    for s in temp:
        answer += s
    answer = re.sub('[.]{2,}', '.', answer)
    size = len(answer)
    if size > 0 and answer[0] == '.':
        answer = answer[1:]
        size -= 1
    if size > 0 and answer[size-1]=='.':
        answer = answer[:size-1]
        size-=1
    if size == 0:
        answer = 'a'
        size = 1
    if size >= 16:
        answer = answer[:15]
        size = 15
        if answer[14] == '.':
            answer = answer[:14]
            size = 14
    elif size <=2:
        for i in range(3-size):
            answer += answer[size-1]
    return answer
