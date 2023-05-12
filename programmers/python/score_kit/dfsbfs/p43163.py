from collections import defaultdict


def is_change(word1, word2):
    count = 0
    for i in range(len(word1)):
        if word1[i] != word2[i]:
            count += 1
            if count > 1:
                return False
    return True if count != 0 else False


def bfs(begin, target, data, count):
    q = [begin]
    depth = 0

    while q:
        word = q.pop(0)
        depth += 1
        for next_word in data[word]:
            if next_word == target:
                return count[word] + 1

            if count[next_word] > 0:
                continue

            count[next_word] = count[word] + 1
            q.append(next_word)

    return 0


def solution(begin, target, words):
    data = defaultdict(list)
    count = defaultdict(int)
    words.append(begin)

    for word1 in words:
        count[word1] = 0
        for word2 in words:
            if is_change(word1, word2):
                data[word1].append(word2)

    return bfs(begin, target, data, count)


print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]))
print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log"]))
