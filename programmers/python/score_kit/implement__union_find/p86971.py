def solution(n, wires):
    answer = int(1e9)
    wires.sort(key=lambda x: x[0])

    for i in range(len(wires)):
        parent = [0] * (n + 1)
        for k in range(1, (n + 1)):
            parent[k] = k

        left = 0
        right = 0

        for j in range(len(wires)):
            if i == j:
                continue

            wire = wires[j]
            union_parent(parent, wire[0], wire[1])

        based = parent[1]
        for g in range(1, n + 1):
            if parent[g] == based:
                left += 1
            else:
                right += 1
        answer = min(answer, abs(left - right))

    return answer


def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b