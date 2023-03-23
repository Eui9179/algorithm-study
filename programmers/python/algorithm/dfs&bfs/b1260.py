def dfs(n: int, graph: list, start: int):
    stack = []
    visited = [False] * (n + 1)

    stack.append(start)

    while stack:
        vertex = stack.pop(0)
        if visited[vertex]:
            continue

        print(vertex, end=" ")

        visited[vertex] = True
        stack = sorted(graph[vertex]) + stack


def bfs(n: int, graph: list, start: int):
    queue = []
    visited = [False] * (n + 1)
    queue.append(start)

    while queue:
        vertex = queue.pop(0)
        if visited[vertex]:
            continue

        print(vertex, end=" ")

        visited[vertex] = True
        queue = queue + sorted(graph[vertex])


n, m, v = map(int, input().split())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

dfs(n, graph, v)
print()
bfs(n, graph, v)