from functools import cmp_to_key


def solution(numbers: list):
    if sum(numbers) == 0:
        return '0'
    numbers_str = [str(n) for n in numbers]
    numbers_str.sort(key=cmp_to_key(compare))

    return ''.join(numbers_str)


def compare(n1: str, n2: str):
    return int(n2 + n1) - int(n1 + n2)


solution([6, 10, 2])