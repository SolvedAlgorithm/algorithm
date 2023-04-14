def main():
    test_case = int(input())
    for _ in range(test_case):
        n = int(input())
        parent = dict()
        number = dict()
        for _ in range(n):
            x, y = input().split()
            if x not in parent:
                parent[x] = x
                number[x] = 1
            if y not in parent:
                parent[y] = y
                number[y] = 1
            union(x, y, parent, number)
            print(number[find(parent[x],parent)])
def find(x, parent):
    if parent[x] == x:
        return x
    else:
        p = find(parent[x], parent)
        parent[x] = p
        return parent[x]
def union(x, y, parent, number):
    x = find(x, parent)
    y = find(y, parent)
    if x != y:
        parent[y] = x
        number[x] += number[y]
main()
