def solution(s):
    answer = True
    ST = []
    for ch in s:
        if ch == '(':
            ST.append(ch)
        elif ch == ')':
            if len(ST) == 0:
                return False
            ST.pop()
    if len(ST) == 0:
        return True
    return False