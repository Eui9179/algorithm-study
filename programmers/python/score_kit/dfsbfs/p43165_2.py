answer = 0

def dfs(numbers, index, sum_num, target):
    global answer

    if index == len(numbers):
        if sum_num == target:
            answer += 1
        return

    dfs(numbers, index + 1, sum_num + numbers[index], target)
    dfs(numbers, index + 1, sum_num - numbers[index], target)


def solution(numbers, target):
    dfs(numbers, 0, 0, target)
    return answer

print(solution([1, 1, 1, 1, 1], 3))