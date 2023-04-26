from itertools import combinations
from collections import deque
import copy


def count_0(n, m, graph):
    count = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                count += 1

    return count


def dfs(n, m, graph, virus):
    q = deque([])
    directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    for v in virus:
        q.append(v)

    while q:
        node = q.popleft()
        graph[node[0]][node[1]] = 2

        for direction in directions:
            ni = node[0] + direction[0]
            nj = node[1] + direction[1]

            if ni < 0 or nj < 0 or ni >= n or nj >= m:
                continue
            if graph[ni][nj] != 0:
                continue
            q.append((ni, nj))


def test(n, m, graph: list, virus: list, wall: tuple):
    test_graph = copy.deepcopy(graph)

    wall1 = wall[0]
    wall2 = wall[1]
    wall3 = wall[2]

    test_graph[wall1[0]][wall1[1]] = 1
    test_graph[wall2[0]][wall2[1]] = 1
    test_graph[wall3[0]][wall3[1]] = 1

    dfs(n, m, test_graph, virus)

    return count_0(n, m, test_graph)


n, m = map(int, input().split())
graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))

virus = []  # 바이러스 위치
possible = []  # 벽을 세울 수 있는 위치
for i in range(n):
    for j in range(m):
        if graph[i][j] == 2:
            virus.append((i, j))
        elif graph[i][j] == 0:
            possible.append((i, j))

possible_wall = list(combinations(possible, 3))

answer = 0
for wall in possible_wall:
    print(wall)
    answer = max(answer, test(n, m, graph, virus, wall))

print(answer)
