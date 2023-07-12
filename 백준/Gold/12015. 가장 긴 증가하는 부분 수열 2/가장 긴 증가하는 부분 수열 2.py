from bisect import bisect_left
def main():
  n = int(input())
  number = list(map(int, input().split()))
  answer = [number[0]]
  if n == 1:
    print(1)
    return
  for i in range(1, n):
    if answer[-1] < number[i]:
      answer.append(number[i])
    else:
      if answer[-1] == number[i]:
        continue
      if len(answer) == 1:
        answer = [number[i]]
        continue
      idx = bisect_left(answer, number[i])
      answer[idx] = number[i]

  print(len(answer))

main()