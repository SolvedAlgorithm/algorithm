n = int(input())
def factorial(n):
  answer = 1;
  if(n == 0):
    return 1;
  
  for i in range(2, n+1):
    answer *= i
  return answer
fact = str(factorial(n))
size = len(fact)
cnt = 0;
for i in range(size-1, -1, -1):
  if fact[i] !='0':
    break
  cnt+=1
print(cnt)
