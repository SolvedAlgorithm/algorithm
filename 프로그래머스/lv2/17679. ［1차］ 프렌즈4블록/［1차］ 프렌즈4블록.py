def solution(m, n, board):
    answer = 0
    for i in range(len(board)):
        board[i] = list(board[i])
    while True:
        points = get_points(m, n, board)
        if len(points) == 0:
            break
        board, cnt = bomb(points, board)
        answer += cnt
        board = update(board)
    return answer
# 4블록을 이루는 사각형의 왼쪽 위 포인트를 구하기
def get_points(m, n, board):
    points = []
    for i in range(m):
        for j in range(n):
            if board[i][j] == '-':
                continue
            if check(i, j, board):
                points.append((i, j))
    return points
# (i, j)를 왼쪽 위칸으로 생각해서 4블록을 이루는지 확인
def check(i, j, board): 
    ni = i + 1
    nj = j + 1
    if ni >= len(board)  or nj >= len(board[0]):
        return False
    if board[i][j] == board[ni][j] and board[i][j] == board[i][j+1] and board[i][j] == board[ni][nj]:
        return True
    return False
# points 배열에 있는 point를 기준으로 4블록을 -로 만든다
def bomb(points, board):
    cnt = 0
    di = [0, 0, 1, 1]
    dj = [0, 1, 0, 1]
    for point in points:
        for k in range(len(di)):
            ni = point[0] + di[k]
            nj = point[1] + dj[k]
            if board[ni][nj] != '-':
                cnt+=1
                board[ni][nj] = '-'
    return board, cnt
# board 배열에서 빈 공간을 없앤다
def update(board):
    for j in range(len(board[0])):
        temp = []
        for i in range(len(board)):
            if board[i][j] != '-':
                temp.append(board[i][j])
        temp = ['-' for _ in range(len(board)-len(temp))] + temp
        for i in range(len(board)):
            board[i][j] = temp[i]
    return board
        