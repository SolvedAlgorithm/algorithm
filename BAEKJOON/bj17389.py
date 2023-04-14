n = int(input())
ox = input()

bonus = 0
score = 0
for i in range(n):
    if ox[i] == 'O' or ox[i] == 79:
        score += (i+1) + bonus
        bonus += 1
    elif ox[i] == 'X' or ox[i] == 88:
        bonus = 0
print(score)