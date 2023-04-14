'''
신장 트리란 하나의 그래프가 있을 때, 모든 노드를 포함하면서 사이클이 존재하지 않는 부분 그래프를 의미한다.
크루스칼 알고리즘은 최소한의 비용으로 신장트리를 찾을 때 사용한다.
'''


def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union_parent(parent, a, b):
    print(a, " ", b)
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    print(a, " ", b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b
    print(parent)
    print()


v = 7

parent_list = [0] * (v + 1)
for i in range(1, v + 1):
    parent_list[i] = i

unions = [
    (1, 2, 29),
    (1, 5, 75),
    (2, 3, 35),
    (2, 6, 34),
    (3, 4, 7),
    (4, 6, 23),
    (4, 7, 13),
    (5, 6, 53),
    (6, 7, 25)
]

unions.sort(key=lambda x: x[2])

edges = []
result = 0

for union in unions:
    a, b, cost = union

    if find_parent(parent_list, a) == find_parent(parent_list, b):
        continue

    union_parent(parent_list, a, b)
    edges.append((union[0], union[1]))
    result += cost

print(edges)
print(result)
