def solution(food):
    left = ''
    for i in range(1, len(food)):
        if food[i] % 2 != 0:
            food[i] -= 1
        left += str(i) * int(food[i] / 2)
    right = ''.join(sorted(list(left), reverse=True))

    return left + '0' + right

print(solution([1,3,4,6]))