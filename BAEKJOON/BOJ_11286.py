import heapq
import sys
input = sys.stdin.readline
def main():
    Nq = []
    Pq = []
    case = int(input())
    for _ in range(case):
        temp = int(input())
        if temp == 0:
            if len(Nq) == 0 and len(Pq) == 0:
                print(0)
            elif len(Nq) == 0 or len(Pq) == 0:
                if len(Nq) == 0:
                    positive = heapq.heappop(Pq)
                    print(positive[1])
                else:
                    negative = heapq.heappop(Nq)
                    print(negative[1])
            else:
                negative = heapq.heappop(Nq)
                positive = heapq.heappop(Pq)
                if negative[0] > positive[0]:
                    print(positive[1])
                    heapq.heappush(Nq, negative)
                else:
                    print(negative[1])
                    heapq.heappush(Pq, positive)
        elif temp < 0:
            heapq.heappush(Nq, (-temp, temp))
        else:
            heapq.heappush(Pq, (temp, temp))


main()