def solution(graph, i, j):
    if len(graph) <= i or i < 0 or len(graph[0]) <= j or j < 0:
        return False

    if graph[i][j] == "1":
        return False

    graph[i][j] = "1"
    solution(graph, i + 1, j)
    solution(graph, i - 1, j)
    solution(graph, i, j + 1)
    solution(graph, i, j - 1)
    return True


n, m = map(int, input().split())
graph = []

for i in range(n):
    line = input()
    graph.append(list(line))

answer = 0

for i in range(n):
    for j in range(m):
        if graph[i][j] == "0":
            if solution(graph, i, j):
                answer += 1

print(answer)
