S = input()
ans = ""
word = ""
tag_chk = False
for c in S:
    if c == '<':
        tag_chk = True
        word += c
    elif c == '>':
        tag_chk = False
        ans += word + '>'
        word = ""
    elif c == ' ':
        if tag_chk:
            word += ' '
        else:
            ans += word + " "
            word = ""
    else:
        if tag_chk:
            word += c
        else:
            word = c + word
if word != "":
    ans += word
print(ans)