parens = input()
stack = []
fault = False
for c in parens:
    if c == '(' or c == '[':
        stack.append(c)
    elif c == ')':
        if len(stack) == 0:
            fault = True
            break
        temp = 0
        while type(stack[-1]) == int:
            temp += stack.pop()
            if len(stack) == 0:
                fault = True
                break
        if fault:
            break
        if stack[-1] == '(':
            stack.pop()
            if(temp == 0):
                stack.append(2)
            else:
                stack.append(temp * 2)
        else:
            fault = True
            break
    elif c == ']':
        if len(stack) == 0:
            fault = True
            break
        temp = 0
        while type(stack[-1]) == int:
            temp += stack.pop()
            if len(stack) == 0:
                fault = True
                break
        if fault:
            fault = True
            break
        if stack[-1] == '[':
            stack.pop()
            if(temp == 0):
                stack.append(3)
            else:
                stack.append(temp * 3)
    else:
        fault = True
        break
        
answer = 0
while stack:
    a = stack.pop()
    if type(a) == int:
        answer += a
    else:
        fault = True
        break
if fault:
    print(0)
else:
    print(answer)