import heapq

n, m, c = map(int, input().split())
inf = int(1e9)

q = []
distance = [inf] * (n + 1)
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    x, y, z = map(int, input().split())
    graph[x].append((y, z))

heapq.heappush(q, (0, c))
distance[c] = 0

while q:
    dist, now = heapq.heappop(q)
    
    if distance[now] < dist:
        continue
    
    for ver in graph[now]:
        cost = ver[1] + dist
        if cost < distance[ver[0]]:
            distance[ver[0]] = cost
            heapq.heappush(q, (cost, ver[0]))

print(distance)