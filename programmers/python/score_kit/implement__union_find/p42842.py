def solution(brown, yellow):
    for i in range(1, yellow + 1):
        if yellow % i != 0:
            continue
        right = yellow//i
        comb = (max(i, right), min(i, right))
        if ((comb[0] + 2) * 2) + (comb[1] * 2) == brown:
            return [comb[0] + 2, comb[1] + 2]

print(solution(8, 1))