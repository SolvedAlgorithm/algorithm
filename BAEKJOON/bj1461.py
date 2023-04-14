import sys
input = sys.stdin.readline
n, m = map(int, input().split())

temp = list(map(int, input().split()))
pos_book = []
neg_book = []
for i in temp:
    if i > 0:
        pos_book.append(i)
    else:
        neg_book.append(i * (-1))
pos_book.sort(reverse=True)
neg_book.sort(reverse=True)

def SUM(data):
    idx = 0
    result = 0
    while idx < len(data):
        result += data[idx] * 2
        idx += m
    return result

result = SUM(pos_book) + SUM(neg_book)
if len(pos_book) == 0:
    result -= neg_book[0]
    print(result)
    sys.exit()
if len(neg_book) == 0:
    result -= pos_book[0]
    print(result)
    sys.exit()

if pos_book[0] < neg_book[0]:
    result -= neg_book[0]
else:
    result -= pos_book[0]
print(result)