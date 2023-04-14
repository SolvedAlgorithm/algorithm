dice = list(map(int, input().split()))
length = len(set(dice))

score = 0
if length == 1:
    score = 10000 + dice[0] * 1000
elif length == 2:
    dice_dict = {}
    for i in dice:
        if i in dice_dict:
            dice_dict[i] += 1
        else:
            dice_dict[i] = 1
    for k, v in dice_dict.items():
        if v == 2:      
            score = 1000 + 100 * k        
elif length == 3:
    score = 100 * max(dice)
print(score)
