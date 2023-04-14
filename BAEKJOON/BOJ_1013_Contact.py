import re
chk = re.compile('(100+1+|01)+')

testcase = int(input())
for i in range(testcase):
  temp = input()
  chk_match  = chk.fullmatch(temp)
  if chk_match == None:
    print("NO")
  else:
      print("YES")