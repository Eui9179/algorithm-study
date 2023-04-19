def solution(n):
    return n_1(n, 1, 3, 2)


def n_1(n, f, t, e):

    if n == 2:
        return [[f, e], [f, t], [e, t]]
    if n == 1:
        return [[f, t]]

    return n_1(n-1, f, e, t) + n_1(1, f, t, e) + n_1(n-1, e, t, f)

print(solution(3))