import heapq
inf = int(1e9)

def dijkstra(n, start):
    q = []
    distance = [inf] * (n + 1)
    graph = [[] for _ in range(n + 1)]
    
    heapq.heappush(q, (0, start))
    distance[start] = 0
    
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))