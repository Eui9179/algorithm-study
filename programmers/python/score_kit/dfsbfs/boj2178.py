from collections import deque


def bfs(n, m, graph, dist):
    directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    q = deque([(0, 0)])
    dist[0][0] = 1

    while q:
        node = q.popleft()

        for direction in directions:
            ni = node[0] + direction[0]
            nj = node[1] + direction[1]

            if ni < 0 or nj < 0 or ni >= n or nj >= m:
                continue
            if graph[ni][nj] == 0 or dist[ni][nj] > 0:
                continue

            dist[ni][nj] = dist[node[0]][node[1]] + 1
            q.append((ni, nj))


n, m = map(int, input().split())

visited = [[False] * m for _ in range(n)]
dist = [[0] * m for _ in range(n)]
graph = []

for _ in range(n):
    s = input()
    graph.append([int(i) for i in list(s)])

bfs(n, m, graph, dist)
print(dist[n - 1][m - 1])
