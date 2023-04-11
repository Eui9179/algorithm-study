import math
from itertools import permutations


def solution(numbers):
    answer = set()
    num_list = list(numbers)

    for i in range(1, len(numbers) + 1):
        comb = list(permutations(num_list, i))
        for c in comb:
            num = int(''.join(list(c)))
            if is_prime(num):
                answer.add(num)

    return len(answer)


def is_prime(num):
    if num == 1:
        return False

    if num != 2 and num % 2 == 0:
        return False

    for i in range(3, int(math.sqrt(num))):
        if num % i == 0:
            return False

    return True

print(solution("011"))