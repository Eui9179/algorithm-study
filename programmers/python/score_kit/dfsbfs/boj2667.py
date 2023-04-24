def dfs(n, graph, visited, i, j):
    global houses, group_cnt
    group_cnt += 1
    visited[i][j] = True
    directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    for direction in directions:
        ni = i + direction[0]
        nj = j + direction[1]
        if ni < 0 or ni >= n or nj < 0 or nj >= n:
            continue
        if visited[ni][nj]:
            continue
        if graph[ni][nj] == '0':
            continue

        dfs(n, graph, visited, ni, nj)


n = int(input())
graph = []
for i in range(n):
    graph.append(list(input()))

visited = [[False] * n for _ in range(n)]

count = 0
houses = []
group_cnt = 0

for i in range(n):
    for j in range(n):
        if not visited[i][j] and graph[i][j] == '1':
            dfs(n, graph, visited, i, j)
            houses.append(group_cnt)
            group_cnt = 0

houses.sort()
print(len(houses))
for h in houses:
    print(h)
