from collections import defaultdict


def search(n, graph, w_table, l_table, start):
    q = [start]
    visited = [False] * (n + 1)
    while q:
        node = q.pop(0)
        visited[node] = True

        for next_node in graph[node]:
            if visited[next_node]:
                continue

            w_table[start].add(next_node)
            l_table[next_node].add(start)

            q.append(next_node)


def solution(n, results):
    answer = 0
    graph = defaultdict(list)
    w_table = {a: set() for a in range(1, n + 1)}
    l_table = {a: set() for a in range(1, n + 1)}

    for f, t in results:
        graph[f].append(t)

    for node in range(1, n + 1):
        search(n, graph, w_table, l_table, node)

    for i in range(1, n + 1):
        if len(w_table[i]) + len(l_table[i]) == n - 1:
            answer += 1

    return answer


# print(solution(5, [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]), 2)
# print(solution(7, [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5], [5,6], [6,7]]), 4)
# print(solution(6, [[1,2], [2,3], [3,4], [4,5], [5,6]]), 6)
# print(solution(3, [[1,2],[1,3]]), 1)
# print(solution(6, [[1,6],[2,6],[3,6],[4,6]]), 0)
# print(solution(8, [[1,2],[3,4],[5,6],[7,8]]),0)
# print(solution(6, [[1,2],[2,3],[3,4],[4,5],[5,6],[2,4],[2,6]]), 6)
# print(solution(4, [[1,2],[1,3],[3,4]]), 1)


print(solution(5, [[1, 4], [4, 2], [2, 5], [5, 3]]), 5)
print(solution(5, [[3, 5], [4, 2], [4, 5], [5, 1], [5, 2]]), 1)
print(solution(9, [[1,2],[1,3],[1,4],[1,5],[6,1],[7,1],[8,1],[9,1]]), 1)
print(solution(4, [[4,3],[4,2],[3,2],[3,1],[4,1], [2,1]]), 4)
print(solution(3,[[3,2],[3,1]]), 1)
