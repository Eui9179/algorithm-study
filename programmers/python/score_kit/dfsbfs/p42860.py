alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"


def get_start_end(n: int, chars: list):
    start = n + 1  # 아예 벗어나게
    end = n + 1  # 아예 벗어나게
    count = 0

    for i in range(n):
        j = i
        while j < n and chars[j] == 'A':
            j += 1

        if count < j - i:
            count = j - i
            start = i
            end = j

    if end != n + 1:
        end -= 1

    return start, end


def is_visited_all(visited, a_start, a_end):
    if a_start - 1 not in visited and a_end + 1 not in visited:
        return True

    elif a_start not in visited:
        if visited[a_end + 1][a_end]:
            return True

    elif a_end + 1 not in visited:
        if visited[a_start - 1][a_start]:
            return True

    elif visited[a_start - 1][a_start] and visited[a_end + 1][a_end]:
        return True

    return False


def get_count_visited(n, graph, direction, a_start, a_end):
    result = 0
    start = 0
    next_node = [start]
    visited = {}

    for g in graph:
        visited[g] = [False] * n

    while next_node:
        node = next_node.pop(0)
        if node == a_start or node == a_end:
            result -= 1
            if is_visited_all(visited, a_start, a_end):
                break
            direction = 1 if direction == 0 else 0
        else:
            result += 1

        if not visited[node][graph[node][direction]]:
            visited[node][graph[node][direction]] = True
            next_node.append(graph[node][direction])

    return result if result > 0 else 0


def solution(name):
    answer = 0

    n = len(name)
    chars = list(name)

    move = n - 1
    while move > 0 and chars[move] == 'A':
        move -= 1

    for c in chars:
        if c == 'A':
            continue
        answer += min(alpha.index(c), alpha.index('Z') - alpha.index(c) + 1)

    graph = {}

    for i in range(n):
        if i + 1 == n:
            graph[i] = [0, i - 1]
        elif i - 1 < 0:
            graph[i] = [i + 1, n - 1]
        else:
            graph[i] = [i + 1, i - 1]

    a_start, a_end = get_start_end(n, chars)

    direction = 0
    move = min(move, get_count_visited(n, graph, direction, a_start, a_end))

    direction = 1
    move = min(move, get_count_visited(n, graph, direction, a_start, a_end))

    return answer + move