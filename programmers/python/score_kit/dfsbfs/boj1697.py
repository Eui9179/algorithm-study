from collections import deque


def bfs(n, k, dist):
    q = deque([n])

    moves = ['+', '-', '*']

    while q:
        node = q.popleft()

        if node == k:
            break

        for move in moves:
            if move == '+':
                nn = node + 1
            elif move == '-':
                nn = node - 1
            else:
                nn = node * 2

            if nn < 0 or nn > 100000 or dist[nn] > 0:
                continue

            dist[nn] = dist[node] + 1

            q.append(nn)


n, k = map(int, input().split())

dist = [0] * 100001
bfs(n, k, dist)

print(dist[k])
