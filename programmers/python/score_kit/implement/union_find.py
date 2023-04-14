'''
1
2: 1
3: 1
4: 1

5: 6
6
'''


def find_parent(parent, x):
    # 루트 노드가 아니라면 재귀적으로 호출
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


v = 6  # 노드 개수
e = 4  # 간선 개수

parent = [0] * (v + 1)

for i in range(1, v + 1):
    parent[i] = i

union_list = [(1, 4), (2, 3), (2, 4), (5, 6)]

for union in union_list:
    union_parent(parent, union[0], union[1])

# 각 원소가 속한 집단 출력
print("각 원소가 속한 집단 출력")
for i in range(1, v + 1):
    print(find_parent(parent, i))