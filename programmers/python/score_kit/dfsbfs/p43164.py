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

# def solution(tickets):
#     answer = []
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
#     start = "ICN"
#     visited = []
#
#     dfs(graph, visited, start, answer)
#     return answer
#
#
# def dfs(graph, visited, node, answer):
#     answer.append(node)
#     for n in graph[node]:
#         if node + "-" + n in visited:
#             continue
#         visited.append(node + "-" + n)
#         dfs(graph, visited, n, answer)

# def solution(tickets):
#     answer = []
#     stack = []
#     path = []
#     graph = {}
#     path_count = len(tickets) + 1
#     visited = []
#     backtrack = []
#
#     for ticket in tickets:
#         graph[ticket[0]] = []
#         graph[ticket[1]] = []
#
#     for ticket in tickets:
#         graph[ticket[0]].append(ticket[1])
#
#     for ticket in tickets:
#         graph[ticket[0]].sort()
#
#     for node in graph["ICN"]:
#         stack.append("ICN-" + node)
#
#     count = len(graph["ICN"])
#     if count > 1:
#         backlist = []
#         for node in graph["ICN"]:
#             backlist.append("ICN" + "-" + node)
#         backtrack.append((0, backlist))
#     while stack:
#
#         if len(visited) == path_count - 1:
#             tmp = []
#             back = backtrack.pop(0)
#             while not stack[0] in back[1]:
#                 stack.pop(0)
#
#             for v in visited:
#                 tmp.append(v.split("-")[0])
#             tmp.append(visited[-1].split("-")[1])
#             path.append(tmp)
#             visited = visited[:back[0]]
#
#         now = stack.pop(0)
#
#         if now in visited:
#             continue
#
#         split = now.split("-")
#         cur_node = split[1]
#
#         visited.append(now)
#
#         count = len(graph[cur_node])
#         backlist = []
#         for node in graph[cur_node]:
#             if node + "-" + cur_node in visited:
#                 count -= 1
#             else:
#                 backlist.append(cur_node + "-" + node)
#
#         if count > 1:
#             backtrack.insert(0, (len(visited), backlist))
#
#
#         for node in reversed(graph[cur_node]):
#             stack.insert(0, cur_node + "-" + node)
#     print(path)
#     return answer

def solution(tickets):
    answer = []
    city_len = len(tickets)

    rollback = []  # 스택
    stack = []  # 스택
    visited = []
    case = []
    graph = {}

    for ticket in tickets:
        graph[ticket[0]] = []
        graph[ticket[1]] = []

    for ticket in tickets:
        graph[ticket[0]].append(ticket[1])
    print(graph)
    stack.append("START-ICN")

    while True:
        if not stack or len(visited) - 1 == city_len:
            answer.append(case)
            if not rollback:
                break
            print("rollback ", rollback)
            rollback_data = rollback.pop(0)
            print("rollback_data ", rollback_data)
            stack = rollback_data[0]
            visited = rollback_data[1]
            case = rollback_data[2]
            # print(case)
            print()


        path = stack.pop(0)
        pre_node, cur_node = path.split("-")

        cur_path = pre_node + "-" + cur_node

        if cur_path in visited:
            continue

        visited.append(cur_path)
        case.append(cur_path)

        pre_stack = stack

        for node in graph[cur_node]:
            stack.insert(0, cur_node + "-" + node)

        # stack 앞에거 빼고 뒤에거 부터
        # visited에 앞에거 넣고 commit

        count = 0
        for node in graph[cur_node]:
            if not cur_node + "-" + node in visited:
                count += 1

        if count > 1:
            commit = (
                pre_stack,
                visited + [cur_node + "-" + node],
                case
            )
            rollback.insert(0, commit)

    for a in answer:
        print(a)


    return answer


solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL", "SFO"]])
# solution([["ICN", "AOO"], ["AOO", "BOO"], ["BOO", "COO"], ["COO", "DOO"], ["DOO", "EOO"], ["EOO", "DOO"], ["DOO", "COO"], ["COO", "BOO"], ["BOO", "AOO"]])
# ["ICN", "AOO", "BOO", "COO", "DOO", "EOO", "DOO", "COO", "BOO", "AOO"]
