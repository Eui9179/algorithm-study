def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


v = 3

parent = [0] * v

union_list = [
    (0, 1),
    (0, 2),
    (1, 2)
]

is_cycle = False

for u in union_list:
    a = u[0]
    b = u[1]

    union(parent, a, b)

    if find_parent(parent, a) == find_parent(parent, b):
        is_cycle = True

if is_cycle:
    print("사이클 발생")
else:
    print("사이클 없음")
