def solution(people, limit):
    answer = 0
    n = len(people)
    left = 0
    right = n - 1

    people.sort()

    while left <= right:
        if people[left] + people[right] <= limit:
            left += 1
            right -= 1

        elif people[left] + people[right] > limit:
            right -= 1

        answer += 1

    return answer


print(solution([10, 20, 30, 80, 90], 100))
