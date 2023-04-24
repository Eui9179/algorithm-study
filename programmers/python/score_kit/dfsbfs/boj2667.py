def dfs(n, graph, i, j):
    global houses_count
    if 0 <= i < n and 0 <= j < n and graph[i][j] != '0':
        graph[i][j] = '0'
        houses_count += 1
        dfs(n, graph, i + 1, j)
        dfs(n, graph, i - 1, j)
        dfs(n, graph, i, j + 1)
        dfs(n, graph, i, j - 1)
        return True
    return False


n = int(input())
graph = []
for i in range(n):
    graph.append(list(input()))

count = 0
houses = []
houses_count = 0

for i in range(n):
    for j in range(n):
        if dfs(n, graph, i, j):
            count += 1
            houses.append(houses_count)
            houses_count = 0

print(count)
houses.sort()
for h in houses:
    print(h)
