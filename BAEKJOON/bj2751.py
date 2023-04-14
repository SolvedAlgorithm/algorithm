import heapq
import sys
input = sys.stdin.readline
n = int(input())
queue = []
array = []
for _ in range(n):
    temp = int(input())
#    heapq.heappush(queue, temp)
    array.append(temp)

#while queue:
 #   print(heapq.heappop(queue))

def merge_sort(array):
    if(len(array) <= 1):
        return array
    mid = len(array) // 2
    left = merge_sort(array[:mid])
    right = merge_sort(array[mid:])
    i = 0
    j = 0
    k = 0
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            array[k] = left[i]
            i += 1
        else:
            array[k] = right[j]
            j += 1
        k += 1
    if i == len(left):
        while j < len(right):
            array[k] = right[j]
            j += 1
            k += 1
    elif j == len(right):
        while i < len(left):
            array[k] = left[i]
            i += 1
            k += 1
    return array

temp = merge_sort(array)

for i in temp:
    print(i)