import sys
from collections import deque

input = sys.stdin.readline


def sout(graph):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            print(graph[i][j], end=" ")
        print()


def search(n, graph, start, target):
    visited = [0] * (n + 1)
    q = deque([start])

    node = q.popleft()
    for i in range(1, n + 1):
        if graph[node][i] == 1:
            q.append(i)

    while q:
        node = q.popleft()
        if visited[node] > 1:
            continue
        if node == target:
            return 1

        visited[node] += 1

        for i in range(1, n + 1):
            if graph[node][i] == 1:
                q.append(i)

    return 0


n = int(input())
graph = [[0] * (n + 1)]
answer = [[0] * (n + 1) for _ in range(n + 1)]

for _ in range(n):
    graph.append([0] + list(map(int, input().split())))

for i in range(1, n + 1):
    for j in range(1, n + 1):
        answer[i][j] = search(n, graph, i, j)

sout(answer)
