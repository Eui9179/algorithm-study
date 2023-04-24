import sys

sys.setrecursionlimit(10 ** 6)


def dfs(m, n, graph, visited, i, j):
    visited[i][j] = True
    directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    for direction in directions:
        ni = i + direction[0]
        nj = j + direction[1]

        if ni < 0 or nj < 0 or ni >= n or nj >= m:
            continue
        if visited[ni][nj] or graph[ni][nj] == 0:
            continue

        dfs(m, n, graph, visited, ni, nj)


answer = []
test = int(input())
for a in range(test):
    cnt = 0
    m, n, k = map(int, input().split())

    graph = [[0] * m for b in range(n)]

    for c in range(k):
        x, y = map(int, input().split())
        graph[y][x] = 1

    visited = [[False] * m for d in range(n)]

    for i in range(n):
        for j in range(m):
            if visited[i][j] or graph[i][j] == 0:
                continue
            dfs(m, n, graph, visited, i, j)
            cnt += 1
    answer.append(cnt)
    cnt = 0

for an in answer:
    print(an)
