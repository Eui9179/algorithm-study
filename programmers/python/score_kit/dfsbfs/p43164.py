from collections import defaultdict


def dfs(n, graph, visited, node, path):
    if len(path) == n + 1:
        return path

    for next_node in graph[node]:
        if next_node not in visited[node]:
            continue

        visited[node].remove(next_node)
        path.append(next_node)

        result = dfs(n, graph, visited, next_node, path)

        if result:
            return result

        visited[node].append(next_node)
        path.pop(-1)

    print()

def solution(tickets):
    graph = defaultdict(list)
    visited = defaultdict(list)

    for f, t in tickets:
        graph[f].append(t)
        visited[f].append(t)

    for key in graph:
        graph[key].sort()

    return dfs(len(tickets), graph, visited, 'ICN', ['ICN'])


print(solution(
    [["ICN", "BOO"], ["ICN", "BOO"], ["ICN", "COO"], ["COO", "DOO"], ["DOO", "COO"], ["BOO", "DOO"], ["DOO", "BOO"],
     ["BOO", "ICN"], ["COO", "BOO"]]))
