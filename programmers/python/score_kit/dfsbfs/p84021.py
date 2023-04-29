def search_puzzle(puzzles, n, table, visited, i, j):
    '''
    table에서 퍼즐 하나 하나 상대적 위치를 찾는 함수이다. 처음 위치를 기준으로 (0, 0)으로 두고 퍼즐의 각 위치를 구한다.
    '''
    directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
    relative = []
    q = [[i, j]]

    while q:
        node = q.pop(0)

        if visited[node[0]][node[1]]:
            continue

        visited[node[0]][node[1]] = True
        relative.append(node)

        for direction in directions:
            ni = node[0] + direction[0]
            nj = node[1] + direction[1]

            if ni < 0 or nj < 0 or ni >= n or nj >= n:
                continue

            if visited[ni][nj] or table[ni][nj] == 0:
                continue

            q.append([ni, nj])

    relative[0][0] = 0
    relative[0][1] = 0

    for k in range(1, len(relative)):
        relative[k][0] -= i
        relative[k][1] -= j

    puzzles.append(relative)


def separate_puzzle(table):
    '''
    모든 퍼즐을 찾아 분리한다.
    '''
    puzzles = []
    n = len(table)
    visited = [[False] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            if not visited[i][j] and table[i][j] == 1:
                search_puzzle(puzzles, n, table, visited, i, j)

    return puzzles


def rotate_board(board):
    '''
    보드를 회전 시킨다.
    '''
    n = len(board)
    rotated_board = [[0] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            rotated_board[j][n - 1 - i] = board[i][j]

    return rotated_board


def check_board(n, board, i, j, puzzle):
    '''
    퍼즐이 보드에 맞는지 확인한다.
    퍼즐의 각 블럭 상하좌우 확인
    '''
    directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    for p in puzzle:
        ni = i + p[0]
        nj = j + p[1]

        for direction in directions:
            nni = ni + direction[0]
            nnj = nj + direction[1]

            if nni < 0 or nnj < 0 or nni >= n or nnj >= n:
                continue
            if board[nni][nnj] == 0:
                return False

    return True


def rollback(board, i, j, p, puzzle):
    '''
    마지막으로 작업한 위치 기준으로 넣었던 퍼즐을 다시 뺀다.
    '''
    for k in range(p):
        ni = puzzle[k][0] + i
        nj = puzzle[k][1] + j

        board[ni][nj] -= 1


def insert_puzzle(n, board, i, j, puzzle):
    '''
    퍼즐을 넣어보고 보드에 맞는 위치인지 확인한다.
    '''
    for p in range(len(puzzle)):
        ni = puzzle[p][0] + i
        nj = puzzle[p][1] + j

        if ni < 0 or nj < 0 or ni >= n or nj >= n:
            rollback(board, i, j, p, puzzle)
            return
        if board[ni][nj] == 1:
            rollback(board, i, j, p, puzzle)
            return

        board[ni][nj] += 1

    if not check_board(n, board, i, j, puzzle):
        rollback(board, i, j, len(puzzle), puzzle)
        return False

    return True


def process(n, board, puzzle):
    '''
    보드에 하나의 퍼즐을 넣어본다.
    '''
    for i in range(n):
        for j in range(n):
            if board[i][j] == 1:
                continue
            if insert_puzzle(n, board, i, j, puzzle):
                return len(puzzle)
    return 0


def solution(game_board, table):
    answer = 0
    n = len(game_board)
    puzzles = separate_puzzle(table)
    for puzzle in puzzles:
        for _ in range(4):
            # 총 4번 보드 회전
            game_board = rotate_board(game_board)
            result = process(n, game_board, puzzle)
            if result > 0:
                answer += result
                break

    return answer


solution([[1, 1, 0, 0, 1, 0],
          [0, 0, 1, 0, 1, 0],
          [0, 1, 1, 0, 0, 1],
          [1, 1, 0, 1, 1, 1],
          [1, 0, 0, 0, 1, 0],
          [0, 1, 1, 1, 0, 0]],

         [[1, 0, 0, 1, 1, 0],
          [1, 0, 1, 0, 1, 0],
          [0, 1, 1, 0, 1, 1],
          [0, 0, 1, 0, 0, 0],
          [1, 1, 0, 1, 1, 0],
          [0, 1, 0, 0, 0, 0]])
