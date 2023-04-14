import sys
input = sys.stdin.readline

def check(document, search):
    dIdx = 0
    result = 0
    while(len(document)-dIdx >= len(search)):
        if document[dIdx:dIdx+len(search)] == search:
            result += 1
            dIdx += len(search)
        else:
            dIdx += 1
    return result

document = input().rstrip()
search = input().rstrip()
print(check(document, search))
"""
document = document.replace(search, "$")

result = 0
for i in range(len(document)):
    if document[i] == "$":
        result += 1
print(result)
"""