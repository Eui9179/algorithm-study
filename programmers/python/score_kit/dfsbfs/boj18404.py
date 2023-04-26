from collections import deque
import sys

input = sys.stdin.readline


def bfs(n, graph, knight):
    q = deque([knight])
    directions = [(1, 2), (1, -2), (-1, 2), (-1, -2), (-2, 1), (-2, -1), (2, -1), (2, 1)]

    while q:
        node = q.popleft()

        for direction in directions:
            ni = node[0] + direction[0]
            nj = node[1] + direction[1]

            if ni < 0 or nj < 0 or ni >= n or nj >= n:
                continue

            if graph[ni][nj] > 0:
                continue
            else:
                graph[ni][nj] = graph[node[0]][node[1]] + 1
                q.append((ni, nj))


n, m = map(int, input().split())
ki, kj = tuple(map(int, input().split()))

graph = [[0] * n for _ in range(n)]
others = []

for _ in range(m):
    i, j = map(int, input().split())
    others.append((i, j))

bfs(n, graph, (ki - 1, kj - 1))

for other in others:
    print(graph[other[0] - 1][other[1] - 1], end=" ")
