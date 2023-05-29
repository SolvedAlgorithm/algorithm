import sys
temp = input()
while True:
    if temp == ".":
        break
    temp = temp.replace(" ", "")
    stack = []
    answer = ""
    for c in temp:
        if c == '(' or c == '[':
            stack.append(c)
        elif c == ')':
            if len(stack) == 0:
                answer = "no"
                break
            if stack[-1] == '(':
                stack.pop()
            else:
                answer = "no"
                break
        elif c == ']':
            if len(stack) == 0:
                answer = "no"
                break
            if stack[-1] == '[':
                stack.pop()
            else:
                answer = "no"
                break
    if answer == "no" or len(stack) > 0:
        print("no")
    else:    
        print("yes")
    temp = input()
