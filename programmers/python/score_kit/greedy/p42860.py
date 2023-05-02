alpha_pool = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
alpha = {alpha_pool[i]: i for i in range(len(alpha_pool))}


def up_and_down(target):
    if alpha[target] < alpha['Z'] - alpha[target]:
        return alpha[target]
    elif alpha[target] >= alpha['Z'] - alpha[target]:
        return 1 + alpha['Z'] - alpha[target]


def get_start_end(name):
    i = 0
    n = len(name)

    start = n
    end = n

    count = 0
    while i < n:
        j = i
        while j < n and name[j] == 'A':
            j += 1
        if count < j - i:
            count = j - i
            start = i
            end = j
            i = j
        else:
            i += 1

    return start, end


def solution(name):
    answer = 0

    n = len(name)
    move = n - 1
    for i in range(n - 1, -1, -1):
        if name[i] != 'A':
            break
        else:
            move -= 1

    # 상하
    for i in range(n):
        answer += up_and_down(name[i])

    start, end = get_start_end(name)
    move = min(move, (start - 1) * 2 + (n - end))
    move = min(move, 2 * (n - end) + (start - 1))

    if move < 0:
        return answer
    return answer + move


print(solution("BMOABA"))

