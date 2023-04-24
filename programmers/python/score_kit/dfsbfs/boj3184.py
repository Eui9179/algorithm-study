import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

def dfs(r, c, graph, visited, i, j):
    global sheep, wolf

    visited[i][j] = True
    if graph[i][j] == 'o':
        sheep += 1
    elif graph[i][j] == 'v':
        wolf += 1

    directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
    for direction in directions:
        ni = i + direction[0]
        nj = j + direction[1]

        if ni < 0 or nj < 0 or ni >= r or nj >= c:
            continue
        if graph[ni][nj] == "#" or visited[ni][nj]:
            continue

        dfs(r, c, graph, visited, ni, nj)


r, c = map(int, input().split())
graph = []
visited = [[False] * c for _ in range(r)]
sheep = 0
wolf = 0
answer = [sheep, wolf]

for _ in range(r):
    graph.append(list(input()))

for i in range(r):
    for j in range(c):
        if graph[i][j] == "#" or visited[i][j]:
            continue
        dfs(r, c, graph, visited, i, j)

        if sheep > wolf:
            answer[0] += sheep
        else:
            answer[1] += wolf

        sheep = 0
        wolf = 0

print(answer[0], answer[1])

