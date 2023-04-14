from itertools import combinations
n = int(input())
skill = [list(map(int, input().split())) for _ in range(n)]
idx = [i for i in range(n)]

combi = list(combinations(idx, n//2))

def team(start, idx, skill):
  link = [x for x in idx if x not in start]
  start_score = score(start, skill)
  link_score= score(link, skill)
  return abs(start_score - link_score)

def score(member, skill):
  acc = 0
  size = len(member)
  for i in range(size-1):
    for j in range(i, size):
      acc += skill[member[i]][member[j]] + skill[member[j]][member[i]]
  return acc

answer = 100
for start in combi:
  temp = team(start, idx, skill)
  answer = min(answer, temp)
print(answer)

