alpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'


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
    while move > 0 and name[move] == 'A':
        move -= 1

    for c in name:
        if c == 'A':
            continue
        answer += min(alpha.index(c), alpha.index('Z') - alpha.index(c) + 1)

    start, end = get_start_end(name)
    move = min(move, (start - 1) * 2 + (n - end))
    move = min(move, 2 * (n - end) + (start - 1))

    if move < 0:
        return answer
    return answer + move