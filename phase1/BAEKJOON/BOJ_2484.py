def score(dice):
    length = len(set(dice))
    if length == 1:
        return 50000 + dice[0] * 5000
    if length == 4:
        return max(dice) * 100
    if length == 3:
        set_dice = list(set(dice))
        dice.sort()
        for i in range(3):
            if dice[i] == dice[i+1]:
                return 1000 + dice[i] * 100
    if length == 2:
        dice.sort()
        if dice[0] == dice[1] and dice[2] == dice[3]:
            return 2000 + 500 * dice[0] + 500 * dice[3]
        else:
            if dice[0] == dice[1] and dice[1] == dice[2]:
                    return 10000 + 1000 * dice[0]
            if dice[1] == dice[2] and dice[2] == dice[3]:
                    return 10000 + 1000 * dice[3]

N = int(input())
scores = [0 for _ in range(N)]

for i in range(N):
    dice = list(map(int, input().split()))
    scores[i] = score(dice)
print(max(scores))
