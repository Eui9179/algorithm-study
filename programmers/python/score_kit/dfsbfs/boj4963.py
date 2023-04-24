import sys

sys.setrecursionlimit(10 ** 5)
input = sys.stdin.readline


def bfs(w, h, graph, visited, i, j):
    visited[i][j] = True

    directions = [(1, 0), (-1, 0), (0, 1), (0, -1), (-1, -1), (1, -1), (-1, 1), (1, 1)]
    for direction in directions:
        ni = i + direction[0]
        nj = j + direction[1]

        if ni < 0 or nj < 0 or ni >= h or nj >= w:
            continue
        if visited[ni][nj] or graph[ni][nj] == 0:
            continue

        bfs(w, h, graph, visited, ni, nj)


answer = []

while True:
    count = 0

    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break

    graph = []
    visited = [[False] * w for _ in range(h)]

    for _ in range(h):
        graph.append(list(map(int, input().split())))

    for i in range(h):
        for j in range(w):
            if visited[i][j] or graph[i][j] == 0:
                continue
            bfs(w, h, graph, visited, i, j)
            count += 1

    answer.append(count)

for a in answer:
    print(a)
