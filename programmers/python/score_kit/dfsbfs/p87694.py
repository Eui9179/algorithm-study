from collections import deque

def gen_map(rectangle, n):
    maps = []

    for k in range(1, len(rectangle) + 1):
        tmp = [[0] * n for _ in range(n)]
        i1 = rectangle[k - 1][1] * 2
        j1 = rectangle[k - 1][0] * 2

        i2 = rectangle[k - 1][3] * 2
        j2 = rectangle[k - 1][2] * 2

        for j in range(j1, j2 + 1):
            tmp[i1][j] = k
            tmp[i2][j] = k

        for i in range(i1, i2 + 1):
            tmp[i][j1] = k
            tmp[i][j2] = k

        maps.append(tmp)

    for k in range(1, len(maps)):
        for i in range(n):
            for j in range(n):
                if maps[k][i][j] == 0:
                    continue
                if maps[0][i][j] < maps[k][i][j]:
                    maps[0][i][j] = maps[k][i][j]
    return maps[0]


def can_go(rectangle, i, j):
    for rec in rectangle:
        if rec[1] * 2 < i < rec[3] * 2 and rec[0] * 2 < j < rec[2] * 2:
            return False
    return True


def bfs(rectangle, n, map2, dist, start, end):
    q = deque([start])

    directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    while q:

        node = q.popleft()

        if node == end:
            return

        for direction in directions:
            ni = node[0] + direction[0]
            nj = node[1] + direction[1]
            if ni < 0 or nj < 0 or ni >= n or nj >= n:
                continue
            if map2[ni][nj] == 0 or dist[ni][nj] > 0 or not can_go(rectangle, ni, nj):
                continue

            q.append((ni, nj))

            dist[ni][nj] = dist[node[0]][node[1]] + 1


def solution(rectangle, characterX, characterY, itemX, itemY):
    n = 100

    map2 = gen_map(rectangle, n)

    dist = [[0] * n for _ in range(n)]

    bfs(rectangle, n, map2, dist, (characterY * 2, characterX * 2), (itemY * 2, itemX * 2))
    return dist[itemY * 2][itemX * 2] // 2