def solution(maps):
    n = len(maps) - 1
    m = len(maps[0]) - 1

    if maps[n - 1][m] == 0 and maps[n][m - 1] == 0:
        return -1

    steps = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    start = (0, 0, 0, 0)
    q = [start]
    maps[0][0] = 0

    while q:

        now = q.pop(0)

        maps[now[0]][now[1]] = maps[now[2]][now[3]] + 1

        if now[0] == n and now[1] == m:
            return maps[now[0]][now[1]]

        for s in steps:
            next_a = now[0] + s[0]
            next_b = now[1] + s[1]

            if next_a < 0 or next_a >= n + 1 or next_b < 0 or next_b >= m + 1:
                continue

            if maps[next_a][next_b] > 1 or maps[next_a][next_b] == 0:
                continue

            q.append((now[0] + s[0], now[1] + s[1], now[0], now[1]))

    return maps[n][m] if maps[n][m] > 1 else -1


print(solution([
    [1, 0, 1, 1, 1],
    [1, 0, 1, 0, 1],
    [1, 0, 1, 1, 1],
    [1, 1, 1, 0, 1],
    [0, 0, 0, 0, 1]
]))
