import heapq


def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union(parent, a, b):
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


def solution(n, costs):
    answer = 0
    hq = []
    parent = [i for i in range(n)]

    for cost in costs:
        f, t, c = cost
        heapq.heappush(hq, (c, f, t))

    while hq:
        c, f, t = heapq.heappop(hq)
        print(parent)
        a = find_parent(parent, f)
        b = find_parent(parent, t)

        if a == b:
            continue

        union(parent, a, b)
        answer += c

    return answer


print(solution(4, [[0, 1, 1], [0, 2, 2], [1, 2, 5], [1, 3, 1], [2, 3, 8]]))
