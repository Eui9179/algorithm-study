n, m = map(int, input().split())

graph = []

for _ in range(n):
    graph.append(list(map(int, input())))

queue = []
step = [(1, 0), (-1, 0), (0, 1), (0, -1)]

queue.append((0, 0))

while queue:
    i, j = queue.pop(0)
    if graph[i][j] > 0:
        for s in step:
            next_i = i + s[0]
            next_j = j + s[1]
            if next_i < 0 or next_i >= n or next_j < 0 or next_j >= m:
                continue

            if graph[next_i][next_j] == 1:
                graph[next_i][next_j] = graph[i][j] + 1
                queue.append((next_i, next_j))

print(graph[n - 1][m - 1])