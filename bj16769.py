def pour(a, b):
    temp = a[0] + b[0]
    if temp > b[1]:
        b = (b[1], b[1])
        a = (temp-b[1], a[1])
    else:
        b = (temp, b[1])
        a = (0, a[1])
    return a, b

def mixing(one, two, three):
    for _ in range(33):
        one, two = pour(one, two)
        two, three = pour(two, three)
        three, one = pour(three, one)
        
    one, two = pour(one, two)
    return one, two, three
a, b = map(int, input().split())
one = (b, a)    
a, b = map(int, input().split())
two = (b, a)    
a, b = map(int, input().split())
three = (b, a)    

one, two, three = mixing(one, two, three)

print(one[0])
print(two[0])
print(three[0])

