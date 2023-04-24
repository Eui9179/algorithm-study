from collections import deque
import sys

input = sys.stdin.readline


def bfs(graph, visited, start):
    q = deque([start])
    while q:
        node = q.popleft()
        if visited[node]:
            continue
        visited[node] = True
        for v in graph[node]:
            q.append(v)


n, m = map(int, input().split())
graph = {i: [] for i in range(1, n + 1)}
visited = [False] * (n + 1)
answer = 0

for i in range(m):
    f, t = map(int, input().split())
    graph[f].append(t)
    graph[t].append(f)

for i in range(1, n + 1):
    if visited[i]:
        continue
    bfs(graph, visited, i)
    answer += 1

print(answer)
