import sys
from collections import deque


def bfs(n, graph, start):
    q = deque([start])
    visited = [False] * (n + 1)
    count = 0

    while q:
        node = q.popleft()
        if visited[node]:
            continue

        visited[node] = True
        count += 1

        for v in graph[node]:
            q.append(v)

    return count


input = sys.stdin.readline

n = int(input())
l = int(input())

graph = {i: [] for i in range(n + 1)}

for _ in range(l):
    f, t = map(int, input().split())
    graph[f].append(t)
    graph[t].append(f)

print(bfs(n, graph, 1) - 1)