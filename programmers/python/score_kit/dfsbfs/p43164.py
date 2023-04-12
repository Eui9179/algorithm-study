# def solution(tickets):
#     graph = {}
#
#     for ticket in tickets:
#         graph[ticket[0]] = []
#         graph[ticket[1]] = []
#
#     for ticket in tickets:
#         graph[ticket[0]].append(ticket[1])
#         graph[ticket[0]].sort()
#
#     icn_len = len(graph["ICN"])
#     result = [[] for _ in range(icn_len)]
#
#     for i in range(icn_len):
#         visited = []
#         q = ["ICN-" + graph["ICN"][i]]
#         result[i].append("ICN")
#
#         while q:
#             from_to = q.pop(0)
#             if from_to in visited:
#                 continue
#
#             visited.append(from_to)
#
#             to = from_to.split("-")[1]
#             result[i].append(to)
#             # for city in reversed(graph[to]):
#             #     q.insert(0, to + "-" + city)
#             for city in graph[to]:
#                 q.append(to + "-" + city)
#     print(result)

def solution(tickets):
    answer = []
    graph = {}

    for ticket in tickets:
        graph[ticket[0]] = []
        graph[ticket[1]] = []

    for ticket in tickets:
        graph[ticket[0]].append(ticket[1])
        graph[ticket[0]].sort()

    start = "ICN"
    visited = []

    dfs(graph, visited, start, answer)
    return answer


def dfs(graph, visited, node, answer):
    answer.append(node)
    for n in graph[node]:
        if node + "-" + n in visited:
            continue
        visited.append(node + "-" + n)
        dfs(graph, visited, n, answer)



solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]])
# solution([["ICN", "AOO"], ["AOO", "BOO"], ["BOO", "COO"], ["COO", "DOO"], ["DOO", "EOO"], ["EOO", "DOO"], ["DOO", "COO"], ["COO", "BOO"], ["BOO", "AOO"]])
#["ICN", "AOO", "BOO", "COO", "DOO", "EOO", "DOO", "COO", "BOO", "AOO"]