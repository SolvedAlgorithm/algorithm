import sys
input=sys.stdin.readline

n = int(input().rstrip())
books = dict()
for _ in range(n):
    temp = str(input().rstrip())
    if books.get(temp) == None:
        books[temp] = 1
    else:
        books[temp] = books.get(temp) + 1

"""max = 0
for key in books.keys():
    if max < books[key]:
        max = books[key]
"""
max = max(books.values())
result = []
for key in books.keys():
    if max == books[key]:
        result.append(key)

result = sorted(result)

print(result[0])