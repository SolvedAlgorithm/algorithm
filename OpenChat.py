def solution(record):
    enter, leave, change = 0, 1, 2
    
    answer = []
    nick = {}
    log = []
    for s in record:
        temp = s.split()
        if temp[0] == "Enter":
            nick[temp[1]] = temp[2]
            log.append((enter, temp[1]))
        elif temp[0] == "Leave":
            log.append((leave, temp[1]))
        elif temp[0] == "Change":
            nick[temp[1]] = temp[2]
            log.append((change, temp[1]))
    for op, uid in log:
        if op == change:
            continue
        name = nick.get(uid)
        if op == enter:
            answer.append(name + "님이 들어왔습니다.")
        elif op == leave:
            answer.append(name + "님이 나갔습니다.")
    
    return answer