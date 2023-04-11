from functools import cmp_to_key


def solution(numbers):
    if sum(numbers) == 0:
        return '0'
    num_str = [str(n) for n in numbers]
    num_str.sort(reverse=True, key=cmp_to_key(compare))
    return ''.join(num_str)


def compare(x, y):
    if int(x + y) > int(y + x):
        return 1
    elif int(x + y) < int(y + x):
        return -1
    else:
        return 0
