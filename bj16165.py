n, m = map(int, input().split())    # N은 걸그룹 수, M은 문제 수
group_names = {}
name_group = {}

for i in range(n):
    gname = input()
    num = int(input())
    people = ["" for _ in range(num)]
    for j in range(num):
        a = input()
        name_group[a] = gname
        people[j] = a
    people.sort()
    group_names[gname] = people

for i in range(m):
    quiz_name = input()
    quiz_kinds = int(input())
    if quiz_kinds == 0:
        for ans_name in group_names[quiz_name]:
            print(ans_name)
    elif quiz_kinds == 1:
        print(name_group[quiz_name])