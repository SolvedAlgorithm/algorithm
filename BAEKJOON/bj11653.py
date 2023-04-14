N = int(input())

def eratos(N):
    chk = [0 for _ in range(N+1)]
    primes = []
    
    for i in range(2, N+1):
        if chk[i] == 1: continue
        if chk[i] == 0:
            primes.append(i)
            for j in range(i*i, N+1, i):
                chk[j] = 1
    return primes

primes_N = eratos(N)
for i in primes_N:
    while N % i == 0:
        N //= i
        print(i)
    if N == 1:
        break
          