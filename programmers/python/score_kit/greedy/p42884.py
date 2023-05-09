def solution(routes):
    answer = 0

    routes.sort(key=lambda x: x[1])
    c1 = -30001

    for route in routes:
        if c1 < route[0]:
            answer += 1
            c1 = route[1]
    return answer


print(solution([[0, 3], [1, 5], [8, 100], [10, 20]]))
