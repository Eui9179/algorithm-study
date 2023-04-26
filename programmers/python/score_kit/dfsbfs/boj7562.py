from collections import deque
import sys

input = sys.stdin.readline

def sout(n, graph):
    for i in range(n):
        for j in range(n):
            print(graph[i][j], end=" ")
        print()

def dfs(n, graph, start, end):
    q = deque([start])

    directions = [(1, 2), (1, -2), (-1, 2), (-1, -2), (-2, 1), (-2, -1), (2, -1), (2, 1)]

    while q:
        node = q.popleft()

        if node == end:
            return

        for direction in directions:
            ni = node[0] + direction[0]
            nj = node[1] + direction[1]

            if ni < 0 or nj < 0 or ni >= n or nj >= n:
                continue
            if graph[ni][nj] > 0:
                continue

            graph[ni][nj] = graph[node[0]][node[1]] + 1

            q.append((ni, nj))



test = int(input())
answer = []

for t in range(test):
    n = int(input())

    graph = [[0] * n for _ in range(n)]

    si, sj = map(int, input().split())
    ei, ej = map(int, input().split())

    dfs(n, graph, (si, sj), (ei, ej))

    answer.append(graph[ei][ej])

for a in answer:
    print(a)
