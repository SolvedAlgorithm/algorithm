import heapq
def solution(genres, plays):
    answer = []
    songMap = {}        #key : genre, value : song list (play count, index)
    cnt = {}            #key : genre, value : play count
    size = len(genres)
    
    for i in range(size):
        if genres[i] in songMap:
            songMap[genres[i]].append(((-1) * plays[i], i))
            cnt[genres[i]] += plays[i]
        else:
            songMap[genres[i]] = [((-1) * plays[i], i)]
            cnt[genres[i]] = plays[i]
    
    gen_cnt = len(cnt)
    if gen_cnt == 1:
        a = songMap[genres[0]]
        heapq.heapify(a)
        if len(a) == 1:
            answer.append(heapq.heappop(a)[1])
        else:
            answer.append(heapq.heappop(a)[1])
            answer.append(heapq.heappop(a)[1])    
    else:
        sorted_cnt = sorted(cnt.items(), key=lambda item:item[1], reverse = True)
        for i in range(gen_cnt):
            gen = sorted_cnt[i][0]
            a = songMap[gen]
            heapq.heapify(a)
            if len(a) == 1:
                answer.append(heapq.heappop(a)[1])
            else:
                answer.append(heapq.heappop(a)[1])
                answer.append(heapq.heappop(a)[1])
    return answer