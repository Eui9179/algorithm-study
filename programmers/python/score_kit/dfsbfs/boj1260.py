def dfs(n, graph, start):
    stack = [start]
    visited = [False] * (n + 1)

    while stack:
        node = stack.pop(0)
        if visited[node]:
            continue

        print(node, end=" ")

        visited[node] = True
        stack = graph[node] + stack


def bfs(n, graph, start):
    q = [start]
    visited = [False] * (n + 1)

    while q:
        node = q.pop(0)
        if visited[node]:
            continue

        print(node, end=" ")

        visited[node] = True
        q += graph[node]


n, m, start = map(int, input().split())
graph = {node: [] for node in range(1, n + 1)}

for _ in range(m):
    f, t = map(int, input().split())
    graph[f].append(t)
    graph[t].append(f)

for i in range(1, n + 1):
    graph[i].sort()


dfs(n, graph, start)
print()
bfs(n, graph, start)
