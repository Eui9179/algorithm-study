from collections import deque
import sys

def bfs(n, graph, visited, start):
    result = [0] * (n + 1)
    q = deque([start])
    while q:
        node = q.popleft()
        if visited[node]:
            continue
        visited[node] = True

        for v in graph[node]:
            q.append(v)
            if result[v] == 0:
                result[v] = node

    return result


input = sys.stdin.readline

n = int(input())
graph = {node: [] for node in range(n + 1)}
visited = [False] * (n + 1)
answer = [0] * (n + 1)

for _ in range(n - 1):
    f, t = map(int, input().split())
    graph[f].append(t)
    graph[t].append(f)

result = bfs(n, graph, visited, 1)
for i in range(2, len(result)):
    print(result[i])
