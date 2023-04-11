def solution(n, computers):
    visited = [0] * n
    group = 1
    graph = {i: [] for i in range(n)}

    for i in range(n):
        for j in range(n):
            if i == j:
                continue

            if computers[i][j] == 1:
                graph[i].append(j)

    for node in graph.keys():
        q = [node]

        if visited[node] != 0:
            continue

        group += 1

        while q:
            now = q.pop(0)
            if visited[now] != 0:
                continue

            visited[now] = group
            q += graph[now]

    return len(set(visited))