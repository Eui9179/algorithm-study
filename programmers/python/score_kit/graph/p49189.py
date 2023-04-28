from collections import deque


def bfs(graph, dist, start):
    q = deque([start])

    dist[start] = 0

    while q:
        node = q.popleft()

        for v in graph[node]:
            if dist[v] > -1:
                continue
            dist[v] = dist[node] + 1
            q.append(v)


def solution(n, edge):
    answer = 0
    dist = [-1] * (n + 1)
    graph = {i: [] for i in range(n + 1)}

    for e in edge:
        graph[e[0]].append(e[1])
        graph[e[1]].append(e[0])

    bfs(graph, dist, 1)

    max_dist = max(dist)

    for i in range(len(dist)):
        if dist[i] == max_dist:
            answer += 1

    return answer


solution(6, [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]])
