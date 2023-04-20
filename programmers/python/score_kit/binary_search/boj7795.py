def binary_search(a, b, left, right):
    if a > b[-1]:
        return len(b)

    if a < b[0]:
        return 0

    result = 0

    while left <= right:
        mid = (left + right) // 2
        if b[mid] < a:
            left = mid + 1
        elif b[mid] >= a:
            right = mid - 1
            result = mid

    return result


test = int(input())
cases = {}

for i in range(test):
    cases[i] = {}

    an, bn = map(int, input().split())
    cases[i]['a'] = list(map(int, input().split()))
    cases[i]['b'] = sorted(list(map(int, input().split())))

answer = 0

for key in cases:
    for a in cases[key]['a']:
        b = cases[key]['b']
        answer += binary_search(a, b, 0, len(b) - 1)
    print(answer)
    answer = 0
