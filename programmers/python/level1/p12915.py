def solution(strings:list, n):
    strings.sort()
    strings.sort(key=lambda s: s[n])
    return strings

print(solution(["sun", "bed", "car"], 1))