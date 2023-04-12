answer = 0


def solution(begin, target, words):
    global answer

    if not target in words:
        return answer

    visited = []
    dfs(words, visited, 1, begin, target)
    return answer


def dfs(words, visited, depth, cur, target):
    global answer
    if cur in visited:
        return
    visited.append(cur)
    for next in words:
        if is_diff_1(cur, next):
            if next == target:
                answer = depth
                return
            dfs(words, visited, depth + 1, next, target)


def is_diff_1(w1, w2):
    count = 0
    w1_list = list(w1)
    w2_list = list(w2)

    for i in range(len(w1)):
        if not w1_list[i] == w2_list[i]:
            count += 1
    return True if count == 1 else False


print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]))
