from collections import deque
import sys

input = sys.stdin.readline


def move_water(r, c, graph, d, water, directions):
    current = len(water)
    for _ in range(current):
        w = water.popleft()
        for direction in directions:
            nwi = w[0] + direction[0]
            nwj = w[1] + direction[1]

            if nwi < 0 or nwj < 0 or nwi >= r or nwj >= c:
                continue
            if (nwi == d[0] and nwj == d[1]) or graph[nwi][nwj] == 'X' or graph[nwi][nwj] == '*':
                continue

            graph[nwi][nwj] = "*"
            water.append((nwi, nwj))


def move_s(r, c, graph, s, directions, dist):
    current = len(s)
    for _ in range(current):
        hog = s.popleft()
        for direction in directions:
            nsi = hog[0] + direction[0]
            nsj = hog[1] + direction[1]

            if nsi < 0 or nsj < 0 or nsi >= r or nsj >= c:
                continue
            if graph[nsi][nsj] == "*" or graph[nsi][nsj] == "S" or graph[nsi][nsj] == "X":
                continue

            graph[nsi][nsj] = 'S'
            dist[nsi][nsj] = dist[hog[0]][hog[1]] + 1

            s.append((nsi, nsj))


def solution(r, c, graph, d, s, water, dist):
    directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    while s:
        move_water(r, c, graph, d, water, directions)
        move_s(r, c, graph, s, directions, dist)

    if graph[d[0]][d[1]] == 'S':
        return dist[d[0]][d[1]]

    return -1


r, c = map(int, input().split())

graph = []
dist = [[0] * c for _ in range(r)]

for _ in range(r):
    graph.append(list(input()))

s = deque([])
water = deque([])

for i in range(r):
    for j in range(c):
        if graph[i][j] == 'D':
            d = (i, j)

        elif graph[i][j] == 'S':
            s.append((i, j))

        elif graph[i][j] == '*':
            water.append((i, j))

answer = solution(r, c, graph, d, s, water, dist)
if answer > 0:
    print(answer)
else:
    print("KAKTUS")
