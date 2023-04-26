from collections import deque
import copy


def bfs(start, bottles):
    q = deque([start])
    visited = []

    steps = [(0, 1), (0, 2), (1, 0), (1, 2), (2, 0), (2, 1)]
    answer = []

    while q:
        node = q.popleft()

        if node in visited:
            continue

        if node[0] == 0:
            answer.append(node[2])

        visited.append(node)

        for step in steps:
            next_node = copy.deepcopy(node)
            f = step[0]
            t = step[1]
            if node[f] + node[t] > bottles[t]:
                next_node[t] = bottles[t]
                next_node[f] = node[f] - (bottles[t] - node[t])

            else:
                next_node[t] = node[t] + node[f]
                next_node[f] = 0

            q.append(next_node)

    return answer


a, b, c = map(int, input().split())

start = [0, 0, c]

answer = bfs(start, (a, b, c))
for a in sorted(answer):
    print(a, end=" ")

