answer = 0

def solution(numbers, target):
    global answer
    rec(numbers, target, 0, 0)
    return answer


def rec(numbers, target, sum_num, i):
    global answer
    if i == len(numbers):
        if target == sum_num:
            answer += 1
        return

    rec(numbers, target, sum_num + numbers[i], i + 1)
    rec(numbers, target, sum_num - numbers[i], i + 1)