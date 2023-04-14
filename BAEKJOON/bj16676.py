N = input()
if int(N) == 0:
    print(1)
else:
    length = len(N)
    chk = "1" * length
    chk = int(chk)

    if chk > int(N):
        print(length - 1)
    else:
        print(length)
