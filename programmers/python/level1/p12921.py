import math


def solution(n):
    count = 1
    answer = [2]
    for i in range(3, n + 1):
        if i % 2 == 0:
            continue
        if func(i):
            answer.append(i)
            count += 1
    print(answer)
    return answer
    # return count


def func(n):
    print(int(math.sqrt(n)))
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True


solution(10)
